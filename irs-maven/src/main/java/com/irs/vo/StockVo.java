package com.irs.vo;


import com.irs.pojo.TbGoods;
import com.irs.pojo.TbStock;

import java.math.BigDecimal;


public class StockVo extends TbStock {
    private String goodsTypeName;

    private String name;

    private String home;

    private String supplierName;

    private TbGoods goods;

    public String getGoodsTypeName() {
        return goodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName) {
        this.goodsTypeName = goodsTypeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }


    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     *     0 低于 1 正常 2高于警戒线
     */
    private Integer cordonStatus;


    public Integer getCordonStatus() {
        return cordonStatus;
    }

    public void setCordonStatus(Integer cordonStatus) {
        this.cordonStatus = cordonStatus;
    }

    public TbGoods getGoods() {
        return goods;
    }

    public void setGoods(TbGoods goods) {
        this.goods = goods;
    }
}
