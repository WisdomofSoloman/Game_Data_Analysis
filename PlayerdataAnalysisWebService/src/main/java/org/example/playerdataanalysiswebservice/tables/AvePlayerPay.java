package org.example.playerdataanalysiswebservice.tables;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 平均付费概览表（ave_player_pay）
 * 只有 1 行，全服人数/总付费/人均付费
 */
@TableName("ave_player_pay")
public class AvePlayerPay {

    @TableField("players_count")
    private Long playersCount;          // 总玩家数

    @TableField("players_paid")
    private Double playersPaid;         // 总付费金额

    @TableField("player_average_paid")
    private Double playerAveragePaid;   // 人均付费

    /* -------- getter / setter -------- */

    public Long getPlayersCount()             { return playersCount; }
    public void setPlayersCount(Long playersCount) { this.playersCount = playersCount; }

    public Double getPlayersPaid()            { return playersPaid; }
    public void setPlayersPaid(Double playersPaid) { this.playersPaid = playersPaid; }

    public Double getPlayerAveragePaid()      { return playerAveragePaid; }
    public void setPlayerAveragePaid(Double playerAveragePaid) { this.playerAveragePaid = playerAveragePaid; }

    @Override public String toString() {
        return "AvePlayerPay{" +
                "playersCount=" + playersCount +
                ", playersPaid=" + playersPaid +
                ", playerAveragePaid=" + playerAveragePaid +
                '}';
    }
}
