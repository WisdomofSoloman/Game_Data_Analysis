package org.example.scala

import org.apache.spark.sql.DataFrame
import org.example.scala.utils.SparkUtils

object DataProcess {
  def main(args : Array[String]): Unit = {
    val spark = SparkUtils.getSparkSession()
    val url = SparkUtils.url
    val porp = SparkUtils.prop
    val defaultDf : DataFrame = spark.read.option("header", "true")
      .option("inferSchema", "true")
      .option("delimiter", ",")
      .option("charset", "UTF-8")
      .csv("data/tap_fun_test.csv")
      .dropDuplicates()

    defaultDf.createTempView("t_df")

    /*val sqlwashed =
      """
        |select user_id,register_time,wood_add_value,wood_reduce_value,
        |       stone_add_value,stone_reduce_value,
        |       ivory_add_value,ivory_reduce_value,
        |       meat_add_value,meat_reduce_value,
        |       magic_add_value,magic_reduce_value,
        |       infantry_add_value,infantry_reduce_value,
        |       cavalry_add_value,cavalry_reduce_value,
        |       shaman_add_value,shaman_reduce_value,
        |       wound_infantry_add_value,
        |       wound_infantry_reduce_value,
        |       wound_cavalry_add_value,wound_cavalry_reduce_value,
        |       wound_shaman_add_value,wound_shaman_reduce_value,
        |       general_acceleration_add_value,general_acceleration_reduce_value,
        |       pvp_battle_count,pvp_lanch_count,pvp_win_count,
        |       pve_battle_count,pve_lanch_count,pve_win_count,
        |       avg_online_minutes,
        |       pay_price,pay_count
        |from t_df
        |""".stripMargin

    val washedDf : DataFrame = spark.sql(sqlwashed)
    washedDf.write.mode("append").jdbc(SparkUtils.url,"DefaultData",SparkUtils.prop)
    val defaultDf : DataFrame = spark.read.jdbc(SparkUtils.url, "defaultdata", SparkUtils.prop)
    defaultDf.createTempView("t_df")
    defaultDf.show()

    val raids_sql =
      """
        |select user_id as id,
        |       pve_battle_count,
        |       pve_win_count,
        |       round((pve_win_count / pve_battle_count) * 100 , 1) as pve_win_rate,
        |       pvp_battle_count,
        |       pvp_win_count,
        |       round((pvp_win_count / pvp_battle_count) * 100 , 1) as pvp_win_rate
        |from t_df
        |""".stripMargin
    val playerRaidsDf : DataFrame = spark.sql(raids_sql)
    playerRaidsDf.write.mode("append").jdbc(SparkUtils.url,"raids",SparkUtils.prop)

    val playerInfo_sql =
      """
        |select user_id as id,
        |       register_time as reg_time,
        |       avg_online_minutes as avg_oltime
        |from t_df
        |""".stripMargin
    val playerInfoDf : DataFrame = spark.sql(playerInfo_sql)
    playerInfoDf.write.mode("append").jdbc(SparkUtils.url,"players",SparkUtils.prop)

    val res_sql =
      """
        |select user_id as id,
        |       wood_add_value,wood_reduce_value,
        |       stone_add_value,stone_reduce_value,
        |       ivory_add_value,ivory_reduce_value,
        |       meat_add_value,meat_reduce_value,
        |       magic_add_value,magic_reduce_value
        |from t_df
        |""".stripMargin
    val resDf : DataFrame = spark.sql(res_sql)
    resDf.write.mode("append").jdbc(SparkUtils.url,"resource",SparkUtils.prop)

    val Military_sql =
      """
        |select user_id as id,
        |       infantry_add_value,infantry_reduce_value,
        |       cavalry_add_value,cavalry_reduce_value,
        |       shaman_add_value,shaman_reduce_value,
        |       wound_infantry_add_value,wound_infantry_reduce_value,
        |       wound_cavalry_add_value,wound_cavalry_reduce_value,
        |       wound_shaman_add_value,wound_shaman_reduce_value,
        |       general_acceleration_add_value,general_acceleration_reduce_value
        |from t_df
        |""".stripMargin
    val MilitaryDf : DataFrame = spark.sql(Military_sql)
    MilitaryDf.write.mode("append").jdbc(SparkUtils.url,"military",SparkUtils.prop)
*/
    val cost_sql =
      """
        |select user_id as id,
        |       pay_price as paid,
        |       pay_count
        |from t_df
        |""".stripMargin
    val playerCostDf : DataFrame = spark.sql(cost_sql)
    playerCostDf.write.mode("append").jdbc(SparkUtils.url,"cost",SparkUtils.prop)


//用户总消费以及用户总数统计
    /*val t_Cost_Df : DataFrame = spark.read.jdbc(url, "PlayerCost", porp)
    t_Cost_Df.createTempView("t_cost")
    val t_sql_ave_pay =
      """
        |select count(user_id) as players_count,
        |       sum(pay_price) as players_paid
        |from t_cost
        |""".stripMargin
    val t_avePayDf : DataFrame = spark.sql(t_sql_ave_pay)
    t_avePayDf.show()
//用户总数统计存储为用户消费均表
    t_avePayDf.createTempView("t_avePay")
    val sql_ave_pay =
      """
        |select players_count as players_count,
        |       players_paid as players_paid,
        |       (players_paid / players_count) as player_average_paid
        |from t_avePay
        |""".stripMargin
    val avePayDf : DataFrame = spark.sql(sql_ave_pay)
    avePayDf.show()
    avePayDf.write.mode("append").jdbc(url,"ave_player_pay",porp)

    val playerRaidsDf = spark.read.jdbc(url, "PlayerRaids", porp)
    playerRaidsDf.show()
    playerRaidsDf.createTempView("t_raids")

    val playerInfoDf = spark.read.jdbc(url,"playerInfo",porp)
    playerInfoDf.show()
    playerInfoDf.createTempView("t_infos")
//pve排行前十玩家
    val pve_desc =
      """
        |select t1.user_id, register_time, avg_online_minutes, pve_win_count,
        |       round((pve_win_count / pve_battle_count) * 100 , 1) as pve_win_rate
        |from t_raids t1, t_infos t2
        |where t1.user_id = t2.user_id
        |order by pve_win_count desc limit 10
        |""".stripMargin
    val topGamerPvEDf : DataFrame = spark.sql(pve_desc)
    topGamerPvEDf.show()
    topGamerPvEDf.write.mode("append").jdbc(url,"top10_pve_gamers",porp)

//pvp排行前十玩家
    val pvp_desc =
      """
        |select t1.user_id, register_time, avg_online_minutes, pvp_win_count,
        |       round((pvp_win_count / pvp_battle_count) * 100 , 1) as pvp_win_rate
        |from t_raids t1, t_infos t2
        |where t1.user_id = t2.user_id
        |order by pvp_win_count desc limit 10
        |""".stripMargin
    val topGamerPvPDf : DataFrame = spark.sql(pvp_desc)
    topGamerPvPDf.show()
    topGamerPvPDf.write.mode("append").jdbc(url,"top10_pvp_gamers",porp)*/
  }
}
