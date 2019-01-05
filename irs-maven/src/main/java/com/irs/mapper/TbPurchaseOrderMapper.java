package com.irs.mapper;

import com.irs.pojo.TbPurchaseOrder;
import com.irs.pojo.TbPurchaseOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPurchaseOrderMapper {
    long countByExample(TbPurchaseOrderExample example);

    int deleteByExample(TbPurchaseOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbPurchaseOrder record);

    int insertSelective(TbPurchaseOrder record);

    List<TbPurchaseOrder> selectByExample(TbPurchaseOrderExample example);

    TbPurchaseOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbPurchaseOrder record, @Param("example") TbPurchaseOrderExample example);

    int updateByExample(@Param("record") TbPurchaseOrder record, @Param("example") TbPurchaseOrderExample example);

    int updateByPrimaryKeySelective(TbPurchaseOrder record);

    int updateByPrimaryKey(TbPurchaseOrder record);
}