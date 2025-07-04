package org.example.playerdataanalysiswebservice.tables;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 玩家信息表映射（players）
 */
@TableName("players")
public class PlayerInfo {

    /** 主键——玩家 ID */
    @TableId("id")               // 明确数据库列名，避免默认命名策略冲突
    private Integer id;

    /** 注册时间（players.reg_time） */
    @TableField("reg_time")
    private String registerTime;

    /** 平均在线时长（players.avg_oltime，单位：小时） */
    @TableField("avg_oltime")
    private Double averageOnlineTime;

    /* ---------- Getter / Setter ---------- */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public Double getAverageOnlineTime() {
        return averageOnlineTime;
    }

    public void setAverageOnlineTime(Double averageOnlineTime) {
        this.averageOnlineTime = averageOnlineTime;
    }

    /* ---------- toString ---------- */

    @Override
    public String toString() {
        return "PlayerInfo{" +
                "id=" + id +
                ", registerTime='" + registerTime + '\'' +
                ", averageOnlineTime=" + averageOnlineTime +
                '}';
    }
}
