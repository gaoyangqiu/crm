package com.irs.service;


import com.irs.pojo.TbStock;
import com.irs.util.ResultUtil;

public interface StockService {


    ResultUtil selectStock(Integer page, Integer limit);

    void addStock(TbStock stock);


    void deleteStocskByIds(String stockIds);

    TbStock selectStockById(Integer id);

    void updateStock(TbStock stock);
}
