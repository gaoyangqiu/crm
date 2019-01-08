package com.irs.service;


import com.irs.pojo.TbSupplier;
import com.irs.util.ResultUtil;

import java.util.List;


public interface SupplierService {


    ResultUtil selectSupplies(Integer page, Integer limit);

    void addSupplie(TbSupplier supplier);

    void deleteSupplieById(Integer id);

    void deleteSuppliesByIds(String supplieIds);

    TbSupplier selectSupplieById(Integer id);

    void updateSupplie(TbSupplier supplier);

    List<TbSupplier> selectAllSuppliers();
}
