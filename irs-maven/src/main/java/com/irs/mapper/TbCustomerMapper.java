package com.irs.mapper;

import com.irs.pojo.TbCustomer;
import com.irs.pojo.TbCustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCustomerMapper {
    long countByExample(TbCustomerExample example);

    int deleteByExample(TbCustomerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbCustomer record);

    int insertSelective(TbCustomer record);

    List<TbCustomer> selectByExample(TbCustomerExample example);

    TbCustomer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbCustomer record, @Param("example") TbCustomerExample example);

    int updateByExample(@Param("record") TbCustomer record, @Param("example") TbCustomerExample example);

    int updateByPrimaryKeySelective(TbCustomer record);

    int updateByPrimaryKey(TbCustomer record);
}