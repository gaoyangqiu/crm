package com.irs.mapper;

import com.irs.pojo.TbSupplier;
import com.irs.pojo.TbSupplierExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSupplierMapper {
    long countByExample(TbSupplierExample example);

    int deleteByExample(TbSupplierExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSupplier record);

    int insertSelective(TbSupplier record);

    List<TbSupplier> selectByExample(TbSupplierExample example);

    TbSupplier selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSupplier record, @Param("example") TbSupplierExample example);

    int updateByExample(@Param("record") TbSupplier record, @Param("example") TbSupplierExample example);

    int updateByPrimaryKeySelective(TbSupplier record);

    int updateByPrimaryKey(TbSupplier record);
}