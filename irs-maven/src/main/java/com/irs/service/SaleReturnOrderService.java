package com.irs.service;



import com.irs.pojo.TbSaleReturnOrder;
import com.irs.util.ResultUtil;

public interface SaleReturnOrderService {

    ResultUtil selectSaleReturnOrders(Integer page, Integer limit);

    void addSaleReturnOrder(TbSaleReturnOrder saleReturnOrder);

    void deleteSaleReturnOrderById(Integer id);

    void deleteSaleReturnOrdersByIds(String supplieIds);

    TbSaleReturnOrder selectSaleReturnOrderById(Integer id);

    void updateSaleReturnOrder(TbSaleReturnOrder returnOrder);
}
