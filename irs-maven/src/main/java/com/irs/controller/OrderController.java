package com.irs.controller;

import com.carrental.common.RestResult;
import com.carrental.entity.User;
import com.carrental.shopping.service.OrderService;
import com.carrental.shopping.service.vo.PayVo;
import com.carrental.shopping.vo.OrderVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: qgy
 * @Date: 2019/3/31 22:06
 * @Description:
 */

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("/order")
    public String index(){
        return "order";
    }


    @RequestMapping("/orderList")
    @ResponseBody
    public List<OrderVo> orderList(){
        Subject subject= SecurityUtils.getSubject();
        PrincipalCollection res=subject.getPrincipals();
        List ress=res.asList();
        Object o=ress.get(0);
        User user=(User)o;
        Long userId=user.getId();
        return orderService.findOrderByUserId(userId.intValue());
    }

    @RequestMapping("/orderPay")
    @ResponseBody
    public RestResult orderPay(@RequestBody PayVo vo){
        Subject subject= SecurityUtils.getSubject();
        PrincipalCollection res=subject.getPrincipals();
        List ress=res.asList();
        Object o=ress.get(0);
        User user=(User)o;
        Long userId=user.getId();
        orderService.orderPay(vo.getOrderId(),userId);
        return RestResult.success();
    }
}
