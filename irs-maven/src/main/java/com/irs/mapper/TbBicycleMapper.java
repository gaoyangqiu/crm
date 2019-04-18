package com.irs.mapper;

import com.irs.pojo.TbBicycle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbBicycleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbBicycle record);

    int insertSelective(TbBicycle record);

    TbBicycle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbBicycle record);

    int updateByPrimaryKey(TbBicycle record);

    List<TbBicycle> selectByOrderDesc();

    List<TbBicycle> selectByType(@Param("type") Integer type);
}