package com.irs.service;



import com.irs.pojo.TbPurchaseReturnOrder;
import com.irs.util.ResultUtil;

public interface PurchaseReturnOrderService {

    ResultUtil selectPurchaseOrders(Integer page, Integer limit);

    void addPurchaseOrdere(TbPurchaseReturnOrder purchaseOrder);

    void deletePurchaseOrderById(Integer id);

    void deletePurchaseOrdersByIds(String supplieIds);

    TbPurchaseReturnOrder selectPurchaseOrderById(Integer id);

    void updatePurchaseOrder(TbPurchaseReturnOrder returnOrder);
}
