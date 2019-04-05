package com.irs.vo;


import com.irs.pojo.TbOrder;
import lombok.Data;

/**
 * @Author: qgy
 * @Date: 2019/3/31 22:28
 * @Description:
 */
@Data
public class OrderVo extends TbOrder {

    private String bicycleName;

    private String statusName;

    private String bicycleTypeName;

    private String timeShow;
}
