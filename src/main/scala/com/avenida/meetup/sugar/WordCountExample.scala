package com.avenida.meetup.sugar

import com.typesafe.config.Config
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD
import spark.jobserver.{NamedRddSupport, SparkJobValid, SparkJobValidation, SparkJob}

//Spark returns the trait while scala uses immutablemap for Maps
import scala.collection.Map

/**
 * Simple WordCount
 */
object WordCountExample extends SparkJob with NamedRddSupport {

  override def runJob(sc: SparkContext, jobConfig: Config): Map[String, Int] = {
    val allWords: RDD[String] = sc.parallelize(jobConfig.getString("input.string").split(" ").toSeq)
    val map = allWords.map((_, 1)).reduceByKey(_ + _).collectAsMap()
    map
  }

  override def validate(sc: SparkContext, config: Config): SparkJobValidation = {
    SparkJobValid
  }
}
