import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.decode
import org.apache.spark.sql.Column
import tech.sourced.engine.{Engine, EngineDataFrame}

object SourceCodeEngine {

  def main(args: Array[String]) {

    val pathToSivaFiles = args(0)

    val spark = SparkSession.builder.appName("test").master("local[*]").getOrCreate()

    val engine = Engine(spark, pathToSivaFiles, "siva")

    engine.getRepositories.getHEAD.getCommits
      .getTreeEntries
      .getBlobs
      .filter("is_binary == false")
      .dropDuplicates("blob_id")
      .classifyLanguages
      .filter("lang == 'Java'")
      .withColumn("content", decode(new Column("content"), "UTF-8"))
      .select("blob_id", "path", "content")
      .write
      .json("data/repositories_extracted")
  }
}