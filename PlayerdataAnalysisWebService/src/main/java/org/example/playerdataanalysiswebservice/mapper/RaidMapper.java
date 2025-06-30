package org.example.playerdataanalysiswebservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.playerdataanalysiswebservice.tables.PlayerRaids;

@Mapper
public interface RaidMapper extends BaseMapper<PlayerRaids> {
}
