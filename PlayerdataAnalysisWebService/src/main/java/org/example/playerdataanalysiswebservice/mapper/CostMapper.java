package org.example.playerdataanalysiswebservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.playerdataanalysiswebservice.tables.PlayerCost;

@Mapper
public interface CostMapper extends BaseMapper<PlayerCost> {
    @Select("SELECT COUNT(*) FROM cost WHERE paid != 0")
    int countNoneZeroPaid();
}
