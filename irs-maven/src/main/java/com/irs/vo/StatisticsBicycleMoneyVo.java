package com.irs.vo;

import lombok.Data;

/**
 * @Author: qgy
 * @Date: 2019/4/5 14:56
 * @Description:
 */

public class StatisticsBicycleMoneyVo {

    private String name;

    private Integer value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
    
    
}
