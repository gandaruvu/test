package spark;

import com.google.inject.Singleton;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
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
public class YqgSparkUtil {
  private final static String host = "101.200.76.17";
  private final static String sparkMaster = "spark://" + host + ":7077";
  private final static String metastoreUris = "thrift://" + host + ":9083";
  private final static String env = "yqg_dev";

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

  public static void createTableWithClass(String tableName, Class<? extends Serializable> clazz, Map<String, Class> partitionCols) {
    StringBuilder builder = new StringBuilder("create table ");
    builder.append(tableName);
    builder.append("(");
    int cnt = 0;
    for (Field field : clazz.getFields()) {
      if (!classMap.containsKey(field.getType()) || partitionCols.containsKey(field.getName())) {
        continue;
      }
      if (cnt != 0) {
        builder.append(",");
      }
      builder.append(field.getName() + " " + classMap.get(field.getType()));
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
        builder.append(stringClassEntry.getKey() + " " + classMap.get(stringClassEntry.getValue()));
        cnt++;
      }
      builder.append(")");
    }
    builder.append(" STORED AS parquet");
    String tableSql = builder.toString();
    getSession().sql(tableSql);
  }

  public static <T extends Serializable> void insert(List<T> values, String tableName, Class<T> clazz) {
    SparkSession session = getSession();
    Dataset<Row> javaBeanDS = session.createDataFrame(
        values,
        clazz
    );
    String[] cols = session.table(tableName).columns();
    javaBeanDS.registerTempTable("tmp");
    Dataset<Row> ds = session.sql("select " + String.join(",", cols) + " from tmp");
    ds.show();

    ds.write().insertInto(tableName);

  }

  public static void output(String sql) {
    getSession().sql(sql).write().option("header","true").format("com.databricks.spark.csv").mode(SaveMode.Overwrite).save("/tmp/test");
  }
}
