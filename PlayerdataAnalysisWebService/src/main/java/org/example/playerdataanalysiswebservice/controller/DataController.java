package org.example.playerdataanalysiswebservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.playerdataanalysiswebservice.mapper.*;
import org.example.playerdataanalysiswebservice.tables.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public ResMapper resMapper;
    @Autowired
    private CostMapper playerCost;

    @RequestMapping("/api/getOneRes")
    public PlayerRes getOneRes()
    {
        PlayerRes playerRes = resMapper.selectOne(new QueryWrapper<PlayerRes>().eq("id", 15824));
        return playerRes;
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
    public TotalWinRate getTotalWinRate () {
        TotalWinRate totalWinRate = totalWinRateMapper.selectOne(null);
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
}
