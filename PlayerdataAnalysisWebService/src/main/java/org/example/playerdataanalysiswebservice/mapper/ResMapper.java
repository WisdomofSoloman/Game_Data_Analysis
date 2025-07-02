package org.example.playerdataanalysiswebservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.playerdataanalysiswebservice.tables.PlayerRes;

@Mapper
public interface ResMapper extends BaseMapper<PlayerRes> {
}
