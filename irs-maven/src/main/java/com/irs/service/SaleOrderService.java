package com.irs.service;


import com.irs.pojo.TbSaleOrder;
import com.irs.util.ResultUtil;

public interface SaleOrderService {

    ResultUtil selectSaleOrders(Integer page, Integer limit);

    void addSaleOrdere(TbSaleOrder saleOrder);

    void deleteSaleOrderById(Integer id);

    void deleteSaleOrdersByIds(String saleOrderIds);

    TbSaleOrder selectSaleOrderById(Integer id);

    void updateSaleOrder(TbSaleOrder saleOrder);

    ResultUtil queryStatistics();
}
