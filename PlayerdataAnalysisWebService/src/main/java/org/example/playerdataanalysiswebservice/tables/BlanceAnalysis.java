package org.example.playerdataanalysiswebservice.tables;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("balance")
public class BlanceAnalysis {
    @TableField("player_type")
    private String type;
    @TableField("players_count")
    private int count;
    @TableField("win_count")
    private int winCount;
    @TableField("average_win_count")
    private double avg_winCount;
    @TableField("win_rate")
    private double winRate;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    public double getAvg_winCount() {
        return avg_winCount;
    }

    public void setAvg_winCount(double avg_winCount) {
        this.avg_winCount = avg_winCount;
    }

    public double getWinRate() {
        return winRate;
    }

    public void setWinRate(double winRate) {
        this.winRate = winRate;
    }
}
