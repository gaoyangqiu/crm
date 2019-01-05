package com.irs.service.impl;


import com.irs.mapper.TbPurchaseReturnOrderMapper;
import com.irs.pojo.TbPurchaseReturnOrder;
import com.irs.service.PurchaseReturnOrderService;
import com.irs.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseReturnOrderServiceImpl implements PurchaseReturnOrderService {
    @Autowired
    private TbPurchaseReturnOrderMapper purchaseReturnOrderMapper;

    @Override
    public ResultUtil selectPurchaseOrders(Integer page, Integer limit) {
        return null;
    }

    @Override
    public void addPurchaseOrdere(TbPurchaseReturnOrder purchaseOrder) {
        purchaseReturnOrderMapper.insert(purchaseOrder);
    }

    @Override
    public void deletePurchaseOrderById(Integer id) {

    }

    @Override
    public void deletePurchaseOrdersByIds(String supplieIds) {

    }

    @Override
    public TbPurchaseReturnOrder selectPurchaseOrderById(Integer id) {
        return null;
    }

    @Override
    public void updatePurchaseOrder(TbPurchaseReturnOrder returnOrder) {

    }
}
