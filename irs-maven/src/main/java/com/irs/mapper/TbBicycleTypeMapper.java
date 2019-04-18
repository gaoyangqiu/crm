package com.irs.mapper;

import com.irs.pojo.TbBicycleType;

import java.util.List;

public interface TbBicycleTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TbBicycleType record);

    int insertSelective(TbBicycleType record);

    TbBicycleType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbBicycleType record);

    int updateByPrimaryKey(TbBicycleType record);

    List<TbBicycleType> selectAll();

}