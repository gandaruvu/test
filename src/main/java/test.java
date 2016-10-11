/**
 * Created by StevenZhu on 16/9/19.
 */

import lombok.Data;
import spark.YqgSparkUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class test {

  @Data
  public static class Person implements Serializable {
    public String date;
    public Integer id;
    public String name;
    public HashMap<String, Integer> person;
  }

  @Data
  public static class UPerson extends Person {
    public String test;
  }

  public static void main(String[] a) throws InterruptedException {

    Map<String, Class> cols = new HashMap<>();
    cols.put("date", String.class);
    YqgSparkUtil.createTableWithClass("person", UPerson.class, cols);

    List<UPerson> personList = new ArrayList<UPerson>();
    UPerson person = new UPerson();
    person.name = "啊";
    person.id = 11;
    person.date = "22";
    person.test = "99";

    personList.add(person);
    UPerson p = new UPerson();
    p.name = "aa";
    p.id = 12;
    p.date = "22";
    personList.add(p);

    UPerson p1 = new UPerson();
    p1.name = "aa";
    p1.id = 12;
    p1.date = "33";
    personList.add(p1);

    YqgSparkUtil.insert(personList, "person", UPerson.class);

    YqgSparkUtil.output("select * from person");


//
//
//
//    SparkSession spark = SparkSession
//        .builder()
//        .appName("SparkSessionZipsExample")
//        .master("spark://192.168.99.100:7077")
//        .config("spark.dynamicAllocation.enabled", "false")
//        .config("hive.metastore.uris", "thrift://192.168.99.100:9083")
//        .config("spark.driver.port","10086")
//        .config("spark.blockManager.port","10087")
//        //.config("spark.submit.deployMode", "cluster")
//        //.config("spark.metastore.warehouse.dir", "hdfs://:8020/user/hive/warehouse")
//        .config("hive.exec.dynamic.partition.mode", "nonstrict")
//        .enableHiveSupport()
//        .getOrCreate();
//
//
//    //spark.sql("create table if not exists test4(id int,name string) ROW FORMAT delimited fields terminated by '\\001' STORED AS TEXTFILE");
//    //spark.sql("drop table if exists test5");
//    //spark.sql("create table test5 (id int, name string, test string) partitioned by (date string)  STORED AS parquet");
//
//    List<UPerson> personList = new ArrayList<UPerson>();
//    // Create an instance of a Bean class
//    UPerson person = new UPerson();
//    person.name = "啊";
//    person.id = 11;
//    person.date = "22";
//    person.test = "99";
//
//    personList.add(person);
//    UPerson p = new UPerson();
//    p.name = "aa";
//    p.id = 12;
//    p.date = "22";
//    personList.add(p);
//
//    UPerson p1 = new UPerson();
//    p1.name = "aa";
//    p1.id = 12;
//    p1.date = "33";
//    personList.add(p1);
//
//
//    // Encoders are created for Java beans
//    //Encoder<Person> personEncoder = Encoders.bean(Person.class);
//
//    Dataset<Row> javaBeanDS = spark.createDataFrame(
//        personList,
//        UPerson.class
//    );
//
//
//    javaBeanDS.registerTempTable("testk");
//
//    Dataset<Row> ds = spark.sql("select id, name, test, date from testk");
//    ds.show();
////    ds.write().insertInto("test5");
////
////    Dataset<Row> t = spark.sql("select * from test5").select("id");
////    t.show();
//    ds.write().option("header","true").format("com.databricks.spark.csv").mode(SaveMode.Overwrite).saveAsTable("testz");

//
//    Dataset<Row> rs = spark.sql("select * from test4");
//    Encoder<HashMap> encoder = Encoders.bean(HashMap.class);
//    Dataset<HashMap> name = rs.map(new MapFunction<Row, HashMap>() {
//      public HashMap call(Row row) throws Exception {
//        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("1", "1");
//        map.put("啊", 1);
//        return map;
//      }
//    }, encoder);
//    name.show();


// +---+----+
// |age|name|
// +---+----+
// | 32|Andy|
// +---+----+

    // Encoders for most common types are provided in class Encoders
//    Encoder<Integer> integerEncoder = Encoders.INT();
//    Dataset<Integer> primitiveDS = spark.createDataset(Arrays.asList(1, 2, 3), integerEncoder);
//    Dataset<Integer> transformedDS = primitiveDS.map(new MapFunction<Integer, Integer>() {
//      public Integer call(Integer value) throws Exception {
//        return value + 1;
//      }
//    }, integerEncoder);
//    transformedDS.collect(); // Returns [2, 3, 4]
//
//    // DataFrames can be converted to a Dataset by providing a class. Mapping based on name
//    String path = "examples/src/main/resources/people.json";
//    Dataset<Person> peopleDS = spark.read().json(path).as(personEncoder);
//    peopleDS.show();
    Thread.sleep(1000000);
  }


}
