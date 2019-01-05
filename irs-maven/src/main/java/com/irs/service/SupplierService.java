package com.irs.service;


import com.irs.pojo.TbSupplier;
import com.irs.util.ResultUtil;


public interface SupplierService {


    ResultUtil selectSupplies(Integer page, Integer limit);

    void addSupplie(TbSupplier supplier);

    void deleteSupplieById(Integer id);

    void deleteSuppliesByIds(String supplieIds);

    TbSupplier selectSupplieById(Integer id);

    void updateSupplie(TbSupplier supplier);
}
