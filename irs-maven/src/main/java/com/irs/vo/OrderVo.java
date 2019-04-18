package com.irs.vo;


import com.irs.pojo.TbOrder;
import lombok.Data;

/**
 * @Author: qgy
 * @Date: 2019/3/31 22:28
 * @Description:
 */

public class OrderVo extends TbOrder {

    private String bicycleName;

    private String statusName;

    private String bicycleTypeName;

    private String timeShow;

	public String getBicycleName() {
		return bicycleName;
	}

	public void setBicycleName(String bicycleName) {
		this.bicycleName = bicycleName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getBicycleTypeName() {
		return bicycleTypeName;
	}

	public void setBicycleTypeName(String bicycleTypeName) {
		this.bicycleTypeName = bicycleTypeName;
	}

	public String getTimeShow() {
		return timeShow;
	}

	public void setTimeShow(String timeShow) {
		this.timeShow = timeShow;
	}
    
    
}
