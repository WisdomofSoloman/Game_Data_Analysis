package org.example.playerdataanalysiswebservice.tables;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


@TableName("top10_pvp_gamers")
public class TopPvPGamers {

    @TableId("id")
    private Integer id;

    @TableField("reg_time")
    private String registerTime;

    @TableField("avg_oltime")
    private Double avgOnlineTime;

    @TableField("pvp_win_count")
    private Integer pvpWinCount;

    @TableField("pvp_win_rate")
    private Double pvpWinRate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPvpWinRate() {
        return pvpWinRate;
    }

    public void setPvpWinRate(Double pvpWinRate) {
        this.pvpWinRate = pvpWinRate;
    }

    public Integer getPvpWinCount() {
        return pvpWinCount;
    }

    public void setPvpWinCount(Integer pvpWinCount) {
        this.pvpWinCount = pvpWinCount;
    }

    public Double getAvgOnlineTime() {
        return avgOnlineTime;
    }

    public void setAvgOnlineTime(Double avgOnlineTime) {
        this.avgOnlineTime = avgOnlineTime;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }
}

