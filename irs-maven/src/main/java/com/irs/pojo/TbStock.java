package com.irs.pojo;

import java.math.BigDecimal;

public class TbStock {
    private Integer id;

    private Integer goodsId;

    private BigDecimal price;

    private BigDecimal amount;

    private BigDecimal cordon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getCordon() {
        return cordon;
    }

    public void setCordon(BigDecimal cordon) {
        this.cordon = cordon;
    }
}