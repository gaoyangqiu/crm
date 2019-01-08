package com.irs.vo;


import com.irs.pojo.TbGoods;

public class GoodsVo  extends TbGoods {
    private String GoodsTypeName;
    private String supplierName;

    public String getGoodsTypeName() {
        return GoodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName) {
        GoodsTypeName = goodsTypeName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
