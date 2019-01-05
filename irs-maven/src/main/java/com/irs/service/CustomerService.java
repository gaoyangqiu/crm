package com.irs.service;


import com.irs.pojo.TbCustomer;
import com.irs.util.ResultUtil;


public interface CustomerService {


    ResultUtil selectCustomers(Integer page, Integer limit);

    void addCustomers(TbCustomer customer);

    void deleteCustomerById(Integer id);

    void deleteCustomersByIds(String customersIds);

    TbCustomer selectCustomerById(Integer id);

    void updateCustomer(TbCustomer customer);
}
