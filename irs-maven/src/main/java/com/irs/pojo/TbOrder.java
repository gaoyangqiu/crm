package com.irs.pojo;

import java.util.Date;

public class TbOrder {
    private Long id;

    private Long userId;

    private Long TbBicycleId;

    private Date startTime;

    private Date endTime;

    private Long totalPrice;

    private Integer status;

    private Byte dflag;

    private Integer time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTbBicycleId() {
        return TbBicycleId;
    }

    public void setTbBicycleId(Long TbBicycleId) {
        this.TbBicycleId = TbBicycleId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Byte getDflag() {
        return dflag;
    }

    public void setDflag(Byte dflag) {
        this.dflag = dflag;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}