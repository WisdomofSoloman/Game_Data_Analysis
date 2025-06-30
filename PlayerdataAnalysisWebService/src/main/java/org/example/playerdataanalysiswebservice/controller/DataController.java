package org.example.playerdataanalysiswebservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.playerdataanalysiswebservice.mapper.PlayerMapper;
import org.example.playerdataanalysiswebservice.mapper.RaidMapper;
import org.example.playerdataanalysiswebservice.tables.PlayerInfo;
import org.example.playerdataanalysiswebservice.tables.PlayerRaids;
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
}
