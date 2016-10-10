package spark;

import com.google.inject.Singleton;
import org.apache.spark.sql.SparkSession;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * Created by StevenZhu on 16/9/28.
 */
@Singleton
public class YqgSparkUtil {
  private final static String sparkMaster = "spark://192.168.99.100:7077";
  private final static String metastoreUris = "thrift://192.168.99.100:9083";
  private final static String hdfsUrl = "hdfs://192.168.99.100:8020/user/hive/warehouse";

  public List<Class> allowedClasses = Arrays.asList(String.class, Float.class, Double.class, Integer.class);

  private static final SparkSession.Builder sessionBuilder = SparkSession.builder()
      .appName("yqg-stat-spark")
      .master(sparkMaster)
      .config("hive.metastore.uris", metastoreUris)
      .config("spark.metastore.warehouse.dir", hdfsUrl)
      .enableHiveSupport();

  public static SparkSession getSession() {
    return sessionBuilder.getOrCreate();
  }

  public static void createTableWithClass(String tableName, Class<? extends Serializable> clazz, List<String> partitionCols) {
    StringBuilder builder = new StringBuilder("create table ");
    builder.append(tableName);
    builder.append("(");
    int cnt = 0;
    for (Field field : clazz.getFields()) {
      if (cnt != 0) {
        builder.append(",");
      }

      //builder.append(field.getName() + " " + field.getAnnotation());
      cnt++;
    }
  }

  public static <T> void insert(List<T> values, String tableName, Class<T> clazz) {
    // check table exist
    //System.out.println(isTableExists(tableName));
  }
}
