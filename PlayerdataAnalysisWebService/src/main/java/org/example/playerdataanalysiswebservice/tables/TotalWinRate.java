package org.example.playerdataanalysiswebservice.tables;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("total_win_rate")
public class TotalWinRate {
    @TableField("total_pvp_count")
    private int pvpCount;
    @TableField("total_pvp_winrate")
    private double pvpWinRate;
    @TableField("total_pve_count")
    private int pveCount;
    @TableField("total_pve_winrate")
    private double pveWinRate;

    public int getPvpCount() {
        return pvpCount;
    }

    public void setPvpCount(int pvpCount) {
        this.pvpCount = pvpCount;
    }

    public double getPvpWinRate() {
        return pvpWinRate;
    }

    public void setPvpWinRate(double pvpWinRate) {
        this.pvpWinRate = pvpWinRate;
    }

    public int getPveCount() {
        return pveCount;
    }

    public void setPveCount(int pveCount) {
        this.pveCount = pveCount;
    }

    public double getPveWinRate() {
        return pveWinRate;
    }

    public void setPveWinRate(double pveWinRate) {
        this.pveWinRate = pveWinRate;
    }

    @Override
    public String toString() {
        return "TotalWinRate{" +
                "pvpCount=" + pvpCount +
                ", pvpWinRate=" + pvpWinRate +
                ", pveCount=" + pveCount +
                ", pveWinRate=" + pveWinRate +
                '}';
    }
}
