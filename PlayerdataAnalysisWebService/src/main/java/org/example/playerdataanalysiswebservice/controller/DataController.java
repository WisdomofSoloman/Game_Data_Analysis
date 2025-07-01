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

    @RequestMapping("getPlayers")
    public List<PlayerInfo> getAllPlayers () {
        List<PlayerInfo> players = playerMapper.selectList(null );
        return players;
    }
    @RequestMapping("getRaids")
    public List<PlayerRaids> getRaids () {
        List<PlayerRaids> raids = raidMapper.selectList(null);
        return raids;
    }
    @RequestMapping("getTop10PvePlayers")
    public List<TopPvEGamers> getTop10PvePlayers () {
        List<TopPvEGamers>  topPvEGamers = topPvEGamersMapper.selectList(null);
        return topPvEGamers;
    }

    @RequestMapping("getTop10PvpPlayers")
    public List<TopPvPGamers> getTop10PvpPlayers () {
        List<TopPvPGamers>  topPvPGamers = topPvPGamersMapper.selectList(null);
        return topPvPGamers;
    }

    @RequestMapping("getTotalWinRate")
    public List<TotalWinRate> getTotalWinRate () {
        List<TotalWinRate> totalWinRate = totalWinRateMapper.selectList(null);
        return totalWinRate;
    }
}
