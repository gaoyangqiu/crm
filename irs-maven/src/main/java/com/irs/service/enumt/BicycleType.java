package com.irs.service.enumt;

/**
 * @Author: qgy
 * @Date: 2019/3/31 22:35
 * @Description:
 */
public enum BicycleType {
    XIAOHUANGCHE(1,"小黄车"),XIAOHONGCHE(2,"小红车");

    BicycleType(Integer type, String desc) {
        Type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return Type;
    }

    public String getDesc() {
        return desc;
    }

    public static  BicycleType getBicycleType(Integer type){
        for (BicycleType bicycleType : BicycleType.values()) {
            if (type==bicycleType.getType()){
                return bicycleType;
            }
        }
        return null;
    }
    private Integer Type;

    private String desc;
}
