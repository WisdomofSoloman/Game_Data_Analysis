package org.example.playerdataanalysiswebservice.tables;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName; // ★ 自动生成 getter/setter
@TableName("top10_pve_gamers")
public class TopPvEGamers {

    @TableId("id")
    private Integer id;

    @TableField("reg_time")
    private String registerTime;

    @TableField("avg_oltime")
    private Double avgOnlineTime;

    @TableField("pve_win_count")
    private Integer pveWinCount;

    @TableField("pve_win_rate")
    private Double pveWinRate;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getRegisterTime() { return registerTime; }
    public void setRegisterTime(String registerTime) { this.registerTime = registerTime; }

    public Double getAvgOnlineTime() { return avgOnlineTime; }
    public void setAvgOnlineTime(Double avgOnlineTime) { this.avgOnlineTime = avgOnlineTime; }

    public Integer getPveWinCount() { return pveWinCount; }
    public void setPveWinCount(Integer pveWinCount) { this.pveWinCount = pveWinCount; }

    public Double getPveWinRate() { return pveWinRate; }
    public void setPveWinRate(Double pveWinRate) { this.pveWinRate = pveWinRate; }

}
