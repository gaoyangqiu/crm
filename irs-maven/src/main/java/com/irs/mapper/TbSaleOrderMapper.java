package com.irs.mapper;

import com.irs.pojo.TbSaleOrder;
import com.irs.pojo.TbSaleOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSaleOrderMapper {
    long countByExample(TbSaleOrderExample example);

    int deleteByExample(TbSaleOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSaleOrder record);

    int insertSelective(TbSaleOrder record);

    List<TbSaleOrder> selectByExample(TbSaleOrderExample example);

    TbSaleOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSaleOrder record, @Param("example") TbSaleOrderExample example);

    int updateByExample(@Param("record") TbSaleOrder record, @Param("example") TbSaleOrderExample example);

    int updateByPrimaryKeySelective(TbSaleOrder record);

    int updateByPrimaryKey(TbSaleOrder record);
}