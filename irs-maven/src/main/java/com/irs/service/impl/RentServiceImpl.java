package com.irs.service.impl;

import com.carrental.common.RestResult;
import com.carrental.dao.BicycleMapper;
import com.carrental.dao.OrderMapper;
import com.carrental.entity.Bicycle;
import com.carrental.entity.Order;
import com.carrental.entity.PageBean;
import com.carrental.shopping.service.RentService;
import com.carrental.shopping.service.enumt.OrderStatus;
import com.carrental.shopping.service.vo.CreateRentVo;
import com.carrental.shopping.vo.QueryBaseVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: qgy
 * @Date: 2019/3/31 16:15
 * @Description:
 */

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private BicycleMapper bicycleMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public PageBean<List<Bicycle>> getRentList(QueryBaseVo queryvo) {
        PageHelper.startPage(queryvo.getCurr(), queryvo.getLimit());
        List<Bicycle> bicycles=bicycleMapper.findAll();
        Integer cout=bicycleMapper.getCout();
        PageBean<List<Bicycle>> pageBean=new PageBean<>();
        pageBean.setCurrentPage(queryvo.getCurr());
        pageBean.setTotalNum(cout);
        pageBean.setPageSize(queryvo.getLimit());
        pageBean.setItems(bicycles);
        return pageBean;
    }

    @Override
    public List<Bicycle> getRentListAll() {
        List<Bicycle> bicycles=bicycleMapper.findAll();
        return bicycles;
    }

    @Override
    public RestResult createRent(CreateRentVo rentVo) {
        Bicycle bicycle=bicycleMapper.selectByPrimaryKey(rentVo.getBicycleId());
        Order order =new Order();
        order.setStatus(OrderStatus.WEIZHIFU.getStatus());
        order.setBicycleId(rentVo.getBicycleId());
        order.setDflag(0);
        order.setTime(rentVo.getTime());
        order.setUserId(rentVo.getUserId());
        order.setTotalPrice((bicycle.getPrice()*rentVo.getTime()));
        orderMapper.insertSelective(order);
        RestResult restResult=RestResult.success();
        return restResult;
    }
}
