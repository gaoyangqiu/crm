package com.irs.service;


import com.irs.vo.OrderVo;

import java.util.List;

/**
 * @Author: qgy
 * @Date: 2019/3/31 22:10
 * @Description:
 */
public interface ReturnService {

    List<OrderVo> findOrderByUserId(int i);


    void returnPay(Integer orderId);
}
