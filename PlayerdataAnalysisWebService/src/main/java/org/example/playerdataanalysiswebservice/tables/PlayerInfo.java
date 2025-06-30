package org.example.playerdataanalysiswebservice.tables;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.w3c.dom.Text;

@TableName("players")
public class PlayerInfo {
    @TableId
    private int id;
    @TableField("reg_time")
    private String registerTime;
    @TableField("avg_oltime")
    private double averageOnlineTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public double getAverageOnlineTime() {
        return averageOnlineTime;
    }

    public void setAverageOnlineTime(double averageOnlineTime) {
        this.averageOnlineTime = averageOnlineTime;
    }

    @Override
    public String toString() {
        return "Player{ id: "  + id
                + ", 注册日期: "  + registerTime
                + ", 平均在线时长: "  + averageOnlineTime
                + "}\n";
    }
}
