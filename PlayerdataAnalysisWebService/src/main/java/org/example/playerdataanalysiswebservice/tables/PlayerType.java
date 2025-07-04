package org.example.playerdataanalysiswebservice.tables;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("player_type")
public class PlayerType {
    @TableId("id")
    private int p_id;
    @TableField("average_online_time")
    private double avg_online_time;
    @TableField("pve_battle_count")
    private int pve_count;
    @TableField("pvp_battle_count")
    private int pvp_count;
    @TableField("total_battle_count")
    private int total_count;
    @TableField("player_type")
    private String type;
    @TableField("player_battle_pertime")
    private double raid_per_time;

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public double getAvg_online_time() {
        return avg_online_time;
    }

    public void setAvg_online_time(double avg_online_time) {
        this.avg_online_time = avg_online_time;
    }

    public int getPve_count() {
        return pve_count;
    }

    public void setPve_count(int pve_count) {
        this.pve_count = pve_count;
    }

    public int getPvp_count() {
        return pvp_count;
    }

    public void setPvp_count(int pvp_count) {
        this.pvp_count = pvp_count;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRaid_per_time() {
        return raid_per_time;
    }

    public void setRaid_per_time(double raid_per_time) {
        this.raid_per_time = raid_per_time;
    }
}
