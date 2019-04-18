package com.irs.vo;


import com.irs.pojo.TbBicycle;

/**
 * @Author: qgy
 * @Date: 2019/3/31 23:52
 * @Description:
 */

public class BicycleVo extends TbBicycle {

    private String typeName;

    private String placementName;

    public String getPlacementName() {
        return placementName;
    }

    public void setPlacementName(String placementName) {
        this.placementName = placementName;
    }

    public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
    
}
