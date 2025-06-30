package org.example.playerdataanalysiswebservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.playerdataanalysiswebservice.tables.PlayerInfo;

@Mapper
public interface PlayerMapper extends BaseMapper<PlayerInfo> {

}
