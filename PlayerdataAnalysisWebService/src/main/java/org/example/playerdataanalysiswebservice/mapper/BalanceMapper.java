package org.example.playerdataanalysiswebservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.playerdataanalysiswebservice.tables.BlanceAnalysis;

@Mapper
public interface BalanceMapper extends BaseMapper<BlanceAnalysis> {
}
