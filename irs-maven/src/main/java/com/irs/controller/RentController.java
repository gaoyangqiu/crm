package com.irs.controller;

import com.carrental.common.RestResult;
import com.carrental.entity.Bicycle;
import com.carrental.entity.User;
import com.carrental.shopping.service.RentService;
import com.carrental.shopping.service.vo.CreateRentVo;
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
 * @Date: 2019/3/31 14:58
 * @Description:
 */
@Controller
public class RentController {

    @Autowired
    private RentService rentService;
    @RequestMapping("/rent")
    public String rentIndex(){
        return "rent";
    }

    @RequestMapping("/rentDetail")
    public String rentDetail(){
        return "rentDetail";
    }
    @ResponseBody
    @RequestMapping("/rentList")
    public List<Bicycle> getRentList(){
       return rentService.getRentListAll();

    }


    @ResponseBody
    @RequestMapping("/createRent")
    public RestResult createRent(@RequestBody CreateRentVo rentVo){
        Subject subject= SecurityUtils.getSubject();
        PrincipalCollection res=subject.getPrincipals();
        List ress=res.asList();
        Object o=ress.get(0);
        User user=(User)o;
        Long userId=user.getId();
        rentVo.setUserId(userId.intValue());
        return rentService.createRent(rentVo);

    }
}
