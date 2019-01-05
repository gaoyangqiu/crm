package com.irs.mapper;

import com.irs.pojo.TbSaleReturnOrder;
import com.irs.pojo.TbSaleReturnOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSaleReturnOrderMapper {
    long countByExample(TbSaleReturnOrderExample example);

    int deleteByExample(TbSaleReturnOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSaleReturnOrder record);

    int insertSelective(TbSaleReturnOrder record);

    List<TbSaleReturnOrder> selectByExample(TbSaleReturnOrderExample example);

    TbSaleReturnOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSaleReturnOrder record, @Param("example") TbSaleReturnOrderExample example);

    int updateByExample(@Param("record") TbSaleReturnOrder record, @Param("example") TbSaleReturnOrderExample example);

    int updateByPrimaryKeySelective(TbSaleReturnOrder record);

    int updateByPrimaryKey(TbSaleReturnOrder record);
}