package org.example.playerdataanalysiswebservice;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.playerdataanalysiswebservice.mapper.*;
import org.example.playerdataanalysiswebservice.tables.*;
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
    @Autowired
    private ResMapper resMapper;
    @Test
    void getOneRes()
    {
        PlayerRes playerRes = resMapper.selectOne(new QueryWrapper<PlayerRes>().eq("id", 15704));
        System.out.println(playerRes);
    }

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
//查询充钱不为零的
@Autowired
private CostMapper playerCost;
    @Test
    void test4() {
        int bCostCount = playerCost.selectList(new QueryWrapper<PlayerCost>().gt("paid", 30)).size();
        int nCostCount = playerCost.selectList(new QueryWrapper<PlayerCost>().gt("paid", 0).le("paid",30)).size();
        int zCostCount = playerCost.selectList(new QueryWrapper<PlayerCost>().eq("paid", 0)).size();
//        int noCostCount = playerCost.countNoneZeroPaid();
        System.out.println(bCostCount);
        System.out.println(nCostCount);
        System.out.println(zCostCount);
//        System.out.println(noCostCount);
    }


}
