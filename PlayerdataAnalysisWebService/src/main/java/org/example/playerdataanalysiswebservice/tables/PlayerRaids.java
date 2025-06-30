package org.example.playerdataanalysiswebservice.tables;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("raids")
public class PlayerRaids {
    @TableId
    private int id;
    @TableField("pvp_battle_count")
    private int pvpCount;
    @TableField("pvp_win_count")
    private int pvpWinCount;
    @TableField("pvp_win_rate")
    private double pvpWinRate;
    @TableField("pve_battle_count")
    private int pveCount;
    @TableField("pve_win_count")
    private int pveWinCount;
    @TableField("pve_win_rate")
    private double pveWinRate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPvpCount() {
        return pvpCount;
    }

    public void setPvpCount(int pvpCount) {
        this.pvpCount = pvpCount;
    }

    public int getPvpWinCount() {
        return pvpWinCount;
    }

    public void setPvpWinCount(int pvpWinCount) {
        this.pvpWinCount = pvpWinCount;
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

    public int getPveWinCount() {
        return pveWinCount;
    }

    public void setPveWinCount(int pveWinCount) {
        this.pveWinCount = pveWinCount;
    }

    public double getPveWinRate() {
        return pveWinRate;
    }

    public void setPveWinRate(double pveWinRate) {
        this.pveWinRate = pveWinRate;
    }
    @Override
    public String toString () {
        return "{ id: " + id
                + ", pvpCount: " + pvpCount
                + ", pvpWinCount: " + pvpWinCount
                + ", pvpWinRate: " + pvpWinRate
                + ", pveCount: " + pveCount
                + ", pveWinCount: " + pveWinCount
                + ", pveWinRate: " + pveWinRate +
                "% }\n";
    }
}
