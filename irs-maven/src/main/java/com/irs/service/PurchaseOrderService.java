package com.irs.service;


import com.irs.pojo.TbPurchaseOrder;
import com.irs.util.ResultUtil;

public interface PurchaseOrderService {

    ResultUtil selectPurchaseOrders(Integer page, Integer limit);

    void addPurchaseOrdere(TbPurchaseOrder purchaseOrder);

    void deletePurchaseOrderById(Integer id);

    void deletePurchaseOrdersByIds(String supplieIds);

    TbPurchaseOrder selectPurchaseOrderById(Integer id);

    void updatePurchaseOrder(TbPurchaseOrder purchaseOrder);
}
