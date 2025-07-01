package org.example.playerdataanalysiswebservice.tables;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("top10_pvp_gamers")
public class TopPvPGamers {
    @TableId
    private int id;
    @TableField("reg_time")
    private String register_time;
    @TableField("avg_oltime")
    private double avg_online_time;
    @TableField("pvp_win_count")
    private int pvp_winCount;
    @TableField("pvp_win_rate")
    private double pvp_winRate;

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

    public int getPvp_winCount() {
        return pvp_winCount;
    }

    public void setPvp_winCount(int pvp_winCount) {
        this.pvp_winCount = pvp_winCount;
    }

    public double getPvp_winRate() {
        return pvp_winRate;
    }

    public void setPvp_winRate(double pvp_winRate) {
        this.pvp_winRate = pvp_winRate;
    }

}
