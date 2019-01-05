package com.irs.mapper;

import com.irs.pojo.TbPurchaseReturnOrder;
import com.irs.pojo.TbPurchaseReturnOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPurchaseReturnOrderMapper {
    long countByExample(TbPurchaseReturnOrderExample example);

    int deleteByExample(TbPurchaseReturnOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPurchaseReturnOrder record);

    int insertSelective(TbPurchaseReturnOrder record);

    List<TbPurchaseReturnOrder> selectByExample(TbPurchaseReturnOrderExample example);

    TbPurchaseReturnOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPurchaseReturnOrder record, @Param("example") TbPurchaseReturnOrderExample example);

    int updateByExample(@Param("record") TbPurchaseReturnOrder record, @Param("example") TbPurchaseReturnOrderExample example);

    int updateByPrimaryKeySelective(TbPurchaseReturnOrder record);

    int updateByPrimaryKey(TbPurchaseReturnOrder record);
}