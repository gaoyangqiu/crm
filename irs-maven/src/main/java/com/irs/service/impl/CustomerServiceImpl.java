package com.irs.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.TbCustomerMapper;
import com.irs.pojo.TbCustomer;
import com.irs.pojo.TbCustomerExample;
import com.irs.service.CustomerService;
import com.irs.util.ResultUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private TbCustomerMapper customerMapper;
    @Override
    public ResultUtil selectCustomers(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        TbCustomerExample example=new TbCustomerExample();
        //排序
        example.setOrderByClause("id DESC");
        TbCustomerExample.Criteria criteria = example.createCriteria();
        List<TbCustomer> list = customerMapper.selectByExample(example);
        PageInfo<TbCustomer> pageInfo = new PageInfo<TbCustomer>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public void addCustomers(TbCustomer customer) {
        customerMapper.insert(customer);
    }

    @Override
    public void deleteCustomerById(Integer id) {
        customerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteCustomersByIds(String customersIds) {
        if(!StringUtils.isBlank(customersIds)){
            String[] ids=customersIds.split(",");
            for (String id : ids) {
                customerMapper.deleteByPrimaryKey(Integer.parseInt(id));
            }
        }
    }

    @Override
    public TbCustomer selectCustomerById(Integer id) {
        TbCustomer customer=customerMapper.selectByPrimaryKey(id);
        return customer;
    }

    @Override
    public void updateCustomer(TbCustomer customer) {
        customerMapper.updateByPrimaryKeySelective(customer);
    }
}
