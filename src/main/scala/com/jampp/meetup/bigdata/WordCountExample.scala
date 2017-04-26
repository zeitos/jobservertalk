package com.jampp.meetup.bigdata

import com.typesafe.config.Config
import org.apache.spark.SparkContext._
import org.apache.spark._
import org.apache.spark.rdd.RDD
import spark.jobserver.{NamedRddSupport, SparkJobValid, SparkJobValidation, SparkJob}
import spark.jobserver.api.{SparkJob => NewSparkJob, _}
import org.scalactic._
import scala.util.Try

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

/**
 * This is the same WordCountExample above but implementing the new SparkJob API.  A couple things
 * to notice:
 * - runJob no longer needs to re-parse the input.  The split words are passed straight to RunJob
 * - The output of runJob is typed now so it's more type safe
 * - the config input no longer is mixed with context settings, it purely has the job input
 * - the job could parse the jobId and other environment vars from JobEnvironment
 */

object WordCountExampleNewApi extends NewSparkJob {
  type JobData = Seq[String]
  type JobOutput = collection.Map[String, Long]

  def runJob(sc: SparkContext, runtime: JobEnvironment, data: JobData): JobOutput =
    sc.parallelize(data).countByValue

  def validate(sc: SparkContext, runtime: JobEnvironment, config: Config):
    JobData Or Every[ValidationProblem] = {
    Try(config.getString("input.string").split(" ").toSeq)
      .map(words => Good(words))
      .getOrElse(Bad(One(SingleProblem("No input.string param"))))
  }
}
