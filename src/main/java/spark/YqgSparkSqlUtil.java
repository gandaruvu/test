package spark;

import com.google.inject.Singleton;
import org.apache.commons.lang3.StringUtils;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.Decimal;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by StevenZhu on 16/9/28.
 */
@Singleton
public class YqgSparkSqlUtil {

  private final static String sparkMaster = "spark://10.171.10.106:7077";
  private final static String metastoreUris = "thrift://10.171.10.106:9083";
  public static String envPrefix = "dev_";

  private final static Map<Class, String> classMap = new HashMap<Class, String>() {{
    put(String.class, "string");
    put(Integer.class, "int");
    put(Long.class, "bigint");
    put(Double.class, "double");
    put(Decimal.class, "decimal");
    put(Float.class, "float");
    put(Boolean.class, "boolean");
  }};

  private static final SparkSession.Builder sessionBuilder = SparkSession.builder()
      .appName("yqg-stat-spark")
      .master(sparkMaster)
      .config("hive.metastore.uris", metastoreUris)
      .config("spark.driver.port", "10086")
      .config("spark.blockManager.port", "10087")
      .config("hive.exec.dynamic.partition.mode", "nonstrict")
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
  public static void createTableWithClass(String tableName, Class<? extends Serializable> clazz) {
    tableName = envPrefix + tableName;
    Map<String, Class> partitionCols = new HashMap<>();

    StringBuilder builder = new StringBuilder("create table ");
    builder.append(tableName);
    builder.append("(");
    int cnt = 0;
    for (Field field : clazz.getDeclaredFields()) {
      if (!classMap.containsKey(field.getType())) {
        continue;
      }
      // 检查是否partition字段
      HiveTablePartition annotation = field.getAnnotation(HiveTablePartition.class);
      if (annotation != null) {
        partitionCols.put(field.getName(), field.getType());
        continue;
      }

      if (cnt != 0) {
        builder.append(",");
      }
      builder.append(camelToUnderline(field.getName()) + " " + classMap.get(field.getType()));
      cnt++;
    }
    builder.append(")");
    cnt = 0;
    if (partitionCols != null && partitionCols.size() != 0) {
      builder.append("PARTITIONED BY (");
      for (Map.Entry<String, Class> stringClassEntry : partitionCols.entrySet()) {
        if (!classMap.containsKey(stringClassEntry.getValue())) {
          throw new RuntimeException();
        }
        if (cnt != 0) {
          builder.append(",");
        }
        builder.append(camelToUnderline(stringClassEntry.getKey()) + " " + classMap.get(stringClassEntry.getValue()));
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
    Dataset<Row> javaBeanDS = session.createDataFrame(
        values,
        clazz
    );
    String[] cols = session.table(tableName).columns();
    for (int i = 0; i < cols.length; i++) {
      cols[i] = underlineToCamel(cols[i]);
    }

    String tmpTable = "tmp";
    javaBeanDS.registerTempTable(tmpTable);
    javaBeanDS.show();

    Dataset<Row> ds = session.sql("select " + StringUtils.join(cols, ',') + " from " + tmpTable);

    ds.write().insertInto(tableName);
  }

  /**
   * drop specific partitions
   *
   * @param tableName          table name. final table name will be {environment}_{tableName}
   * @param partitionCondition key: column name, value column value
   */
  public static void dropPartition(String tableName, Map<String, Object> partitionCondition) {
    if (partitionCondition == null || partitionCondition.keySet().size() == 0) {
      throw new RuntimeException("condition cannot be empty");
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
          .append(String.valueOf(partitionCondition))
          .append("'");
      cnt++;
    }
    builder.append(")");
    getSession().sql(builder.toString());
  }

  public static void dropTable(String tableName) {
    getSession().sql("drop table " + envPrefix + tableName);
  }

  /**
   * output. not supported yet...
   *
   * @param sql
   */
  /*
  public static void output(String sql) {
    getSession().sql(sql).write().option("header", "true").format("com.databricks.spark.csv").mode(SaveMode.Overwrite).save("/tmp/test");
  }
  */


  private static final char UNDERLINE = '_';

  private static String camelToUnderline(String param) {
    if (param == null || "".equals(param.trim())) {
      return "";
    }
    int len = param.length();
    StringBuilder sb = new StringBuilder(len);
    for (int i = 0; i < len; i++) {
      char c = param.charAt(i);
      if (Character.isUpperCase(c)) {
        sb.append(UNDERLINE);
        sb.append(Character.toLowerCase(c));
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }

  private static String underlineToCamel(String param) {
    if (param == null || "".equals(param.trim())) {
      return "";
    }
    int len = param.length();
    StringBuilder sb = new StringBuilder(len);
    for (int i = 0; i < len; i++) {
      char c = param.charAt(i);
      if (c == UNDERLINE) {
        if (++i < len) {
          sb.append(Character.toUpperCase(param.charAt(i)));
        }
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}
