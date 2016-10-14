package spark;

import com.google.inject.Singleton;

/**
 * Created by StevenZhu on 16/10/13.
 */
@Singleton
public class YqgSparkConfig {

  //  @Inject
//  @Named("spark.master")
  public String sparkMaster = "spark://namenode:7077";

  //  @Inject
//  @Named("spark.hive.metastore.uris")
  public String metastoreUris = "thrift://namenode:9083";

//  public YqgSparkConfig() {
//    ZookeeperUtil.addWatcher(this);
//  }

}