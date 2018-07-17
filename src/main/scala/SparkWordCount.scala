import org.apache.spark.{SparkConf, SparkContext}

object SparkWordCount {

  def main(args: Array[String]) {

    val sparkConf = new SparkConf()
      .setMaster("local")
      .setAppName("Word Count")

    val sparkContext = new SparkContext(sparkConf)

    val input = sparkContext.textFile("data/in.txt")

    val count = input.flatMap(line ⇒ line.split(" "))
      .map(word ⇒ (word, 1))
      .reduceByKey(_ + _)

    count.saveAsTextFile("data/outfile")
  }
}