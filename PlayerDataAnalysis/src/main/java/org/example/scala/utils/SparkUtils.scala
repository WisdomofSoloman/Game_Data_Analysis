package org.example.scala.utils

import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession

import java.util.Properties

object SparkUtils {

  var url = "jdbc:mysql://localhost:3306/spark?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true"
  var username = "root"
  var pwd = "123456"
  val prop = new Properties()
  prop.setProperty("user", SparkUtils.username)
  prop.setProperty("password", SparkUtils.pwd)

  def getSparkSession() : SparkSession = {
    val spark : SparkSession = SparkSession.builder().appName("sparkApp").master("local[2]").getOrCreate()
    spark.sparkContext.setLogLevel("WARN")
    spark
  }

  def getSparkContext() : SparkContext = {
    getSparkSession().sparkContext
  }

}
