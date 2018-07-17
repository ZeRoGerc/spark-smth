name := "spark-tutorials"

version := "0.1"

scalaVersion := "2.11.11"

//libraryDependencies += "org.apache.spark" %% "spark-core_2.11" % "2.2.1" // from "file:///Users/zerogerc/spark-2.2.1-bin-hadoop2.7"

libraryDependencies += "org.apache.hadoop" % "hadoop-client" % "2.7.3"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.2.1"

libraryDependencies += "tech.sourced" % "engine" % "0.6.4"