package com.irs.mapper;

import com.irs.pojo.TbGoodsType;
import com.irs.pojo.TbGoodsTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbGoodsTypeMapper {
    long countByExample(TbGoodsTypeExample example);

    int deleteByExample(TbGoodsTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbGoodsType record);

    int insertSelective(TbGoodsType record);

    List<TbGoodsType> selectByExample(TbGoodsTypeExample example);

    TbGoodsType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbGoodsType record, @Param("example") TbGoodsTypeExample example);

    int updateByExample(@Param("record") TbGoodsType record, @Param("example") TbGoodsTypeExample example);

    int updateByPrimaryKeySelective(TbGoodsType record);

    int updateByPrimaryKey(TbGoodsType record);
}