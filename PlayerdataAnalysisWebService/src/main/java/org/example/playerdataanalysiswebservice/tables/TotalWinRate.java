package org.example.playerdataanalysiswebservice.tables;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 累计 PVP / PVE 战绩（total_win_rate 表）
 */
@TableName("total_win_rate")
public class TotalWinRate {


    /* ---------- PVP ---------- */

    @TableField("total_pvp_count")
    private Integer pvpCount;

    @TableField("total_pvp_winrate")
    private Double pvpWinRate;

    /* ---------- PVE ---------- */

    @TableField("total_pve_count")
    private Integer pveCount;

    @TableField("total_pve_winrate")
    private Double pveWinRate;

    /* ---------- Getter / Setter ---------- */



    public Integer getPvpCount() {
        return pvpCount;
    }

    public void setPvpCount(Integer pvpCount) {
        this.pvpCount = pvpCount;
    }

    public Double getPvpWinRate() {
        return pvpWinRate;
    }

    public void setPvpWinRate(Double pvpWinRate) {
        this.pvpWinRate = pvpWinRate;
    }

    public Integer getPveCount() {
        return pveCount;
    }

    public void setPveCount(Integer pveCount) {
        this.pveCount = pveCount;
    }

    public Double getPveWinRate() {
        return pveWinRate;
    }

    public void setPveWinRate(Double pveWinRate) {
        this.pveWinRate = pveWinRate;
    }

    /* ---------- toString ---------- */

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
