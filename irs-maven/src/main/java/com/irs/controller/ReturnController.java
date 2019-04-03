package com.irs.controller;

import com.carrental.common.RestResult;
import com.carrental.entity.User;
import com.carrental.shopping.service.ReturnService;
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
public class ReturnController {
    @Autowired
    private ReturnService returnService;
    @RequestMapping("/return")
    public String index(){
        return "return";
    }


    @RequestMapping("/returnList")
    @ResponseBody
    public List<OrderVo> returnList(){
        Subject subject= SecurityUtils.getSubject();
        PrincipalCollection res=subject.getPrincipals();
        List ress=res.asList();
        Object o=ress.get(0);
        User user=(User)o;
        Long userId=user.getId();
        return returnService.findOrderByUserId(userId.intValue());
    }

    @RequestMapping("/returnPay")
    @ResponseBody
    public RestResult returnPay(@RequestBody PayVo vo){
        returnService.returnPay(vo.getOrderId());
        return RestResult.success();
    }
}
