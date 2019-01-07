package com.irs.service;



import com.irs.pojo.TbPurchaseReturnOrder;
import com.irs.util.ResultUtil;

public interface PurchaseReturnOrderService {

    ResultUtil selectPurchaseReturnOrders(Integer page, Integer limit);

    void addPurchaseReturnOrder(TbPurchaseReturnOrder purchaseOrder);

    void deletePurchaseReturnOrderById(Integer id);

    void deletePurchaseReturnOrdersByIds(String supplieIds);

    TbPurchaseReturnOrder selectPurchaseReturnOrderById(Integer id);

    void updatePurchaseReturnOrder(TbPurchaseReturnOrder returnOrder);
}
