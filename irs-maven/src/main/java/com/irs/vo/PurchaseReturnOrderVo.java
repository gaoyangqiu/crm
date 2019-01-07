package com.irs.vo;


import com.irs.pojo.TbPurchaseReturnOrder;

public class PurchaseReturnOrderVo extends TbPurchaseReturnOrder {

    private String goodsName;

    private String supplierName;

    private String userName;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
