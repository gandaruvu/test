package spark;

import com.google.inject.Singleton;
import org.apache.hadoop.fs.LocalFileSystem;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.spark.sql.*;
import org.apache.spark.sql.types.*;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by StevenZhu on 16/9/28.
 */
@Singleton
public class YqgSparkSqlUtil {

  private static YqgSparkConfig yqgSparkConfig = new YqgSparkConfig();
  private final static String sparkMaster = yqgSparkConfig.sparkMaster;
  private final static String metastoreUris = yqgSparkConfig.metastoreUris;
  public static String envPrefix = "dev_";

  private final static Map<Class, HiveType> classMap = new HashMap<Class, HiveType>() {{
    put(String.class, HiveType.STRING);
    put(Integer.class, HiveType.INT);
    put(Long.class, HiveType.LONG);
    put(Double.class, HiveType.DOUBLE);
    put(Decimal.class, HiveType.DECIMAL);
    put(Float.class, HiveType.FLOAT);
    put(Boolean.class, HiveType.BOOLEAN);
  }};

  public enum HiveType {
    STRING("string", DataTypes.StringType),
    INT("int", DataTypes.IntegerType),
    LONG("bigint", DataTypes.LongType),
    DOUBLE("double", DataTypes.DoubleType),
    DECIMAL("decimal", DataTypes.FloatType),
    FLOAT("float", DataTypes.FloatType),
    BOOLEAN("boolean", DataTypes.BooleanType),;
    public String typeName;
    public DataType sparkStruct;

    HiveType(String typeName, DataType sparkStruct) {
      this.typeName = typeName;
      this.sparkStruct = sparkStruct;
    }

  }

  private static final SparkSession.Builder sessionBuilder = SparkSession.builder()
      .appName("yqg-stat-spark")
      .master(sparkMaster)
      .config("hive.metastore.uris", metastoreUris)
      .config("spark.driver.port", "10086")
      .config("spark.blockManager.port", "10087")
      .config("hive.exec.dynamic.partition.mode", "nonstrict")
      .config("fs.hdfs.impl", DistributedFileSystem.class.getName())
      .config("fs.file.impl", LocalFileSystem.class.getName())
      .enableHiveSupport();

  public static SparkSession getSession() {
    return sessionBuilder.getOrCreate();
  }

  /**
   * create table with Class and Partition Column Definition
   *
   * @param tableName table name. final table name will be {environment}_{tableName}
   * @param clazz     table Definition, only support some basic data types now. see classMap
   */
  public static void createTableWithClass(String tableName, Class clazz) {
    tableName = envPrefix + tableName;
    Map<String, Class> partitionCols = new HashMap<>();

    StringBuilder builder = new StringBuilder("create table ");
    builder.append(tableName);
    builder.append("(");
    int cnt = 0;
    Set<Field> fields = getAllowedFields(clazz);

    for (Field field : fields) {
      // 检查是否partition字段
      HiveTablePartition annotation = field.getAnnotation(HiveTablePartition.class);
      if (annotation != null) {
        partitionCols.put(field.getName(), field.getType());
        continue;
      }

      if (cnt != 0) {
        builder.append(",");
      }
      builder.append(field.getName() + " " + classMap.get(field.getType()).typeName);
      cnt++;
    }
    builder.append(")");
    cnt = 0;
    if (partitionCols.size() != 0) {
      builder.append("PARTITIONED BY (");
      for (Map.Entry<String, Class> stringClassEntry : partitionCols.entrySet()) {
        if (!classMap.containsKey(stringClassEntry.getValue())) {
          throw new RuntimeException();
        }
        if (cnt != 0) {
          builder.append(",");
        }
        builder.append(stringClassEntry.getKey() + " " + classMap.get(stringClassEntry.getValue()).typeName);
        cnt++;
      }
      builder.append(")");
    }
    builder.append(" STORED AS parquet");
    String tableSql = builder.toString();
    getSession().sql(tableSql);
  }

  /**
   * insert values into hive
   *
   * @param values    values to be inserted
   * @param tableName table name. final table name will be {environment}_{tableName}
   * @param clazz
   */
  public static <T extends Serializable> void insert(List<T> values, String tableName, Class<T> clazz) {
    tableName = envPrefix + tableName;
    SparkSession session = getSession();

    Set<Field> dataFields = getAllowedFields(clazz);
    String[] columns = session.table(tableName).columns();
    Map<String, Field> fieldMap = new HashMap<>();
    dataFields.forEach(dataField -> fieldMap.put(dataField.getName().toLowerCase(), dataField));

    List<Field> finalDataFields = new ArrayList<>();
    for (String column : columns) {
      if (fieldMap.containsKey(column)) {
        finalDataFields.add(fieldMap.get(column));
      } else {
        dropColumn(tableName, column);
      }
    }

    List<StructField> structFields = new ArrayList<>();
    finalDataFields.forEach(field -> structFields.add(DataTypes.createStructField(field.getName(), classMap.get(field.getType()).sparkStruct, true)));
    StructType schema = DataTypes.createStructType(structFields);

    List<Row> rows = new ArrayList<>();
    values.forEach(value -> {
      List<Object> objects = new ArrayList<>();
      for (Field field : finalDataFields) {
        try {
          field.setAccessible(true);
          objects.add(field.get(value));
        } catch (IllegalAccessException e) {
          throw new RuntimeException("a");
        }
      }

      Row row = RowFactory.create(objects.toArray());
      rows.add(row);
    });

    Dataset<Row> javaBeanDS = session.createDataFrame(rows, schema);

    javaBeanDS.write().insertInto(tableName);
  }

  /**
   * drop specific partitions
   *
   * @param tableName          table name. final table name will be {environment}_{tableName}
   * @param partitionCondition key: column name, value column value
   */
  public static void dropPartition(String tableName, Map<String, Object> partitionCondition) {
    if (partitionCondition == null || partitionCondition.keySet().size() == 0) {
      throw new RuntimeException("a");
    }
    StringBuilder builder = new StringBuilder("ALTER TABLE ");
    builder.append(envPrefix)
        .append(tableName)
        .append(" DROP IF EXISTS PARTITION (");
    int cnt = 0;
    for (Map.Entry<String, Object> entry : partitionCondition.entrySet()) {
      if (cnt != 0) {
        builder.append(",");
      }
      builder.append(entry.getKey())
          .append("='")
          .append(String.valueOf(entry.getValue()))
          .append("'");
      cnt++;
    }
    builder.append(")");
    getSession().sql(builder.toString());
  }

  public static void dropColumn(String tableName, String columnName) {
    String dropSql = "alter table " + envPrefix + tableName + " drop if exists column " + columnName;
    getSession().sql(dropSql);
  }

  public static void addColumn(String tableName, String columnName, Class columnClass) {
    if (!classMap.containsKey(columnClass)) {
      return;
    }
    String dropSql = "alter table " + envPrefix + tableName + " add columns (" + columnName + " " + classMap.get(columnClass).typeName + ")";
    getSession().sql(dropSql);
  }

  public static void dropTable(String tableName) {
    getSession().sql("DROP TABLE IF EXISTS " + envPrefix + tableName);
  }

  /**
   * output. not supported yet...
   */
  /*
  public static void output(String sql) {
    getSession().sql(sql).write().option("header", "true").format("com.databricks.spark.csv").mode(SaveMode.Overwrite).save("/tmp/test");
  }
  */
  private static Set<Field> getAllowedFields(Class clazz) {
    Set<Field> fields = new LinkedHashSet<>();

    for (Field field : clazz.getFields()) {
      if (classMap.containsKey(field.getType())) {
        fields.add(field);
      }
    }
    for (Field field : clazz.getDeclaredFields()) {
      if (classMap.containsKey(field.getType())) {
        fields.add(field);
      }
    }
    return fields;
  }
}
