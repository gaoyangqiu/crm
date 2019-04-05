package com.irs.controller;

import com.irs.service.OrderService;
import com.irs.vo.StatisticsBicycleMoneyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: qgy
 * @Date: 2019/4/5 14:47
 * @Description:
 */
@Controller
@RequestMapping("rentMoney/")
public class RentMoneyCotroller {

    @Autowired
    private OrderService orderService;

    @ResponseBody
    @RequestMapping("statisticsBicycleMoneyData")
    public List<StatisticsBicycleMoneyVo> statisticsBicycleMoneyData(){
        return orderService.statisticsBicycleMoneyVoList();
    }

    @RequestMapping("statisticsBicycleMoney")
    public String statisticsBicycleMoneyVoList(){
        return "page/rentmoney/statisticsBicycleMoney";
    }

}
