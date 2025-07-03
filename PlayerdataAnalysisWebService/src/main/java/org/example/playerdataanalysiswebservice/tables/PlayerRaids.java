package org.example.playerdataanalysiswebservice.tables;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * PVP / PVE 战斗统计（raids 表）
 */
@TableName("raids")
public class PlayerRaids {

    /* ---------- 主键 ---------- */

    @TableId("id")
    private Integer id;

    /* ---------- PVP ---------- */

    @TableField("pvp_battle_count")
    private Integer pvpCount;

    @TableField("pvp_win_count")
    private Integer pvpWinCount;

    @TableField("pvp_win_rate")
    private Double pvpWinRate;

    /* ---------- PVE ---------- */

    @TableField("pve_battle_count")
    private Integer pveCount;

    @TableField("pve_win_count")
    private Integer pveWinCount;

    @TableField("pve_win_rate")
    private Double pveWinRate;

    /* ---------- Getter / Setter ---------- */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPvpCount() {
        return pvpCount;
    }

    public void setPvpCount(Integer pvpCount) {
        this.pvpCount = pvpCount;
    }

    public Integer getPvpWinCount() {
        return pvpWinCount;
    }

    public void setPvpWinCount(Integer pvpWinCount) {
        this.pvpWinCount = pvpWinCount;
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

    public Integer getPveWinCount() {
        return pveWinCount;
    }

    public void setPveWinCount(Integer pveWinCount) {
        this.pveWinCount = pveWinCount;
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
        return "PlayerRaids{" +
                "id=" + id +
                ", pvpCount=" + pvpCount +
                ", pvpWinCount=" + pvpWinCount +
                ", pvpWinRate=" + pvpWinRate +
                ", pveCount=" + pveCount +
                ", pveWinCount=" + pveWinCount +
                ", pveWinRate=" + pveWinRate +
                '}';
    }
}
