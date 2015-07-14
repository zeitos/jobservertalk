package com.avenida.meetup.sugar

import com.typesafe.config.ConfigFactory
import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest._

/**
 * Created by ZeoS on 7/13/15.
 */
class WordCountExampleSpec extends FunSpec with ShouldMatchers with BeforeAndAfterAll {
  @transient var sc: SparkContext = _

  override def beforeAll() {
    super.beforeAll()
    val conf = new SparkConf()
      .setMaster("local[2]")
      .setAppName("MLlibUnitTest")
    sc = new SparkContext(conf)


  }

  override def afterAll() {
    if (sc != null) {
      sc.stop()
    }
  }

  describe("WordCountExample") {
    it("should count words if the provided parameter has words.") {
      import scala.collection.JavaConverters._
      val config = ConfigFactory.parseMap(Map(
        "input.string" -> "word1 word2 word1 word3 word4 word4 word1"
      ).asJava)

      val result = WordCountExample.runJob(sc, config)
      result should contain ("word1" -> 3)
      result should contain ("word2" -> 1)
      result should contain ("word3" -> 1)
      result should contain ("word4" -> 2)
      result should have size(4)
    }
  }

}
