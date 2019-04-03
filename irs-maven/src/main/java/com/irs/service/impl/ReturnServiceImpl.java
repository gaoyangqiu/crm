package com.irs.service.impl;

import com.carrental.dao.BicycleMapper;
import com.carrental.dao.OrderMapper;
import com.carrental.dao.UserMapper;
import com.carrental.entity.Bicycle;
import com.carrental.entity.Order;
import com.carrental.shopping.service.ReturnService;
import com.carrental.shopping.service.enumt.BicycleType;
import com.carrental.shopping.service.enumt.OrderStatus;
import com.carrental.shopping.vo.OrderVo;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Author: qgy
 * @Date: 2019/3/31 22:10
 * @Description:
 */

@Service
public class ReturnServiceImpl implements ReturnService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BicycleMapper bicycleMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<OrderVo> findOrderByUserId(int i) {
        List<Order> orders=orderMapper.findOrderByUserId(i);
        List<OrderVo> orderVos= Lists.newArrayList();
        if (!CollectionUtils.isEmpty(orders)){
            for (Order order : orders) {
                OrderVo vo=new OrderVo();
                BeanUtils.copyProperties(order,vo);
                Bicycle bicycle =bicycleMapper.selectByPrimaryKey(order.getBicycleId());
                vo.setBicycleName(bicycle.getName());
                vo.setBicycleTypeName(BicycleType.getBicycleType(bicycle.getType()).getDesc());
                vo.setStatusName(OrderStatus.getOrderStatus(order.getStatus()).getDesc());
                vo.setTimeShow(order.getTime().toString()+"小时");
                orderVos.add(vo);
            }
        }

        return  orderVos;
    }

    @Override
    public void returnPay(Integer orderId) {
        Order order=new Order();
        order.setStatus(OrderStatus.YIGUIHUAN.getStatus());
        order.setId(orderId.longValue());
        orderMapper.updateByPrimaryKeySelective(order);
    }


}
