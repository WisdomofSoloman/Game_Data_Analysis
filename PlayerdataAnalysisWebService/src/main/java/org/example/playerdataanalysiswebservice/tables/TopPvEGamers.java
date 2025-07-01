package org.example.playerdataanalysiswebservice.tables;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("top10_pve_gamers")
public class TopPvEGamers {
    @TableId
    private int id;
    @TableField("reg_time")
    private String register_time;
    @TableField("avg_oltime")
    private double avg_online_time;
    @TableField("pve_win_count")
    private int pve_winCount;
    @TableField("pve_win_rate")
    private double pve_winRate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegister_time() {
        return register_time;
    }

    public void setRegister_time(String register_time) {
        this.register_time = register_time;
    }

    public double getAvg_online_time() {
        return avg_online_time;
    }

    public void setAvg_online_time(double avg_online_time) {
        this.avg_online_time = avg_online_time;
    }

    public int getPve_winCount() {
        return pve_winCount;
    }

    public void setPve_winCount(int pve_winCount) {
        this.pve_winCount = pve_winCount;
    }

    public double getPve_winRate() {
        return pve_winRate;
    }

    public void setPve_winRate(double pve_winRate) {
        this.pve_winRate = pve_winRate;
    }
}
