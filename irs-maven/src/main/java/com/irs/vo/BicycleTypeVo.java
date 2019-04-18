package com.irs.vo;

import lombok.Data;

/**
 * @Author: qgy
 * @Date: 2019/4/3 22:52
 * @Description:
 */

public class BicycleTypeVo {

    private Integer id;
    private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
}
