package org.example.playerdataanalysiswebservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.playerdataanalysiswebservice.mapper.*;
import org.example.playerdataanalysiswebservice.tables.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.example.playerdataanalysiswebservice.dto.OverallWinRateDTO;

import java.util.List;

@Controller
@ResponseBody
public class DataController {
    //依赖注入,定义接口变量,spring已经创建好变量了.
    @Autowired
    public PlayerMapper playerMapper;
    @Autowired
    public RaidMapper raidMapper;
    @Autowired
    public TopPvPGamersMapper topPvPGamersMapper;
    @Autowired
    public TopPvEGamersMapper topPvEGamersMapper;
    @Autowired
    public TotalWinRateMapper totalWinRateMapper;
    @Autowired
    public CostMapper playerCost;
    @Autowired
    public BalanceMapper balanceMapper;
    @Autowired
    public PlayerTypeMapper playerTypeMapper;

    //根据ID查询玩家近期游玩状况，若不存在则为空
    @RequestMapping("/api/getPlayers/{id}")
    public PlayerType getPlayerType(@PathVariable("id") int p_id){
        PlayerType player = playerTypeMapper.selectById(p_id);
        if(player == null){
            return null;
        } else {
            return player;
        }
    }
    //查询付费/非付费玩家胜率情况
    @RequestMapping("/api/getBlanceinfo")
    public List<BlanceAnalysis> getBalanceInfo() {
        List<BlanceAnalysis> info = balanceMapper.selectList(null );
        return info;
    }

    @RequestMapping("/api/getPlayers")
    public List<PlayerInfo> getAllPlayers () {
        return playerMapper.selectList(null );
    }

    @RequestMapping("/api/getRaids")
    public List<PlayerRaids> getRaids () {
        List<PlayerRaids> raids = raidMapper.selectList(null);
        return raids;
    }
    @RequestMapping("/api/getTop10PvePlayers")
    public List<TopPvEGamers> getTop10PvePlayers () {
        List<TopPvEGamers>  topPvEGamers = topPvEGamersMapper.selectList(null);
        return topPvEGamers;
    }


    @RequestMapping("/api/getTop10PvpPlayers")
    public List<TopPvPGamers> getTop10PvpPlayers () {
        List<TopPvPGamers>  topPvPGamers = topPvPGamersMapper.selectList(null);
        return topPvPGamers;
    }

    @RequestMapping("/api/getTotalWinRate")
    public List<TotalWinRate> getTotalWinRate () {
        List<TotalWinRate> totalWinRate = totalWinRateMapper.selectList(null);
        return totalWinRate;
    }

    @RequestMapping("/api/getCostStatistics")
    @ResponseBody  // 返回JSON格式
    public CostStatistics getCostStatistics() {
        CostStatistics stats = new CostStatistics();

        // 查询并设置各类统计值
        stats.setHighCostCount(playerCost.selectList(new QueryWrapper<PlayerCost>().gt("paid", 30)).size());
        stats.setMediumCostCount(playerCost.selectList(new QueryWrapper<PlayerCost>().gt("paid", 0).le("paid", 30)).size());
        stats.setZeroCostCount(playerCost.selectList(new QueryWrapper<PlayerCost>().eq("paid", 0)).size());

        return stats;
    }

    // －－ 注入 mapper
    @Autowired
    private AvePlayerPayMapper avePlayerPayMapper;
    @RequestMapping("/api/getAvePlayerPay")
    public AvePlayerPay getAvePlayerPay() {
        // LIMIT 1 保守处理：若以后有多行只取第一行
        return avePlayerPayMapper.selectOne(null);
    }


}
