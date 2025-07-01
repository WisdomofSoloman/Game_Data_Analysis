package org.example.playerdataanalysiswebservice;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.playerdataanalysiswebservice.mapper.PlayerMapper;
import org.example.playerdataanalysiswebservice.mapper.RaidMapper;
import org.example.playerdataanalysiswebservice.mapper.TotalWinRateMapper;
import org.example.playerdataanalysiswebservice.tables.PlayerInfo;
import org.example.playerdataanalysiswebservice.tables.PlayerRaids;
import org.example.playerdataanalysiswebservice.tables.TotalWinRate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PlayerdataAnalysisWebServiceApplicationTests {
    @Autowired
    private PlayerMapper playerMapper;
    @Autowired
    private RaidMapper raidMapper;
    @Autowired
    private TotalWinRateMapper totalWinRateMapper;
    @Test
    void contextLoads() {
        List<PlayerInfo> result =  playerMapper.selectList(
                new QueryWrapper<PlayerInfo>()
                        .last("Limit 10")
        );
        System.out.println(result);
    }
    @Test
    void test2() {
        List<PlayerRaids> raids = raidMapper.selectList(
                new QueryWrapper<PlayerRaids>()
                .last("Limit 10")
        );
        System.out.println(raids);
    }
    @Test
    void test3() {
        TotalWinRate winRate = totalWinRateMapper.selectOne(null);
        System.out.println(winRate);
    }
}
