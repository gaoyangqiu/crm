package com.irs.service.impl;

import com.carrental.dao.BicycleMapper;
import com.carrental.dao.OrderMapper;
import com.carrental.dao.UserMapper;
import com.carrental.entity.Bicycle;
import com.carrental.entity.Order;
import com.carrental.entity.User;
import com.carrental.shopping.service.OrderService;
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
public class OrderServiceImpl implements OrderService{

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
                orderVos.add(vo);
            }
        }

        return  orderVos;
    }

    @Override
    public void orderPay(Integer orderId,Long userId) {
        Order order=orderMapper.selectByPrimaryKey(orderId.longValue());
        order.setStatus(OrderStatus.YIZHIFU.getStatus());
        order.setId(orderId.longValue());
        orderMapper.updateByPrimaryKeySelective(order);
        //支付成功之后扣钱
        User user=userMapper.selectByPrimaryKey(order.getUserId().longValue());
        user.setBalance((user.getBalance()-order.getTotalPrice()));
        userMapper.updateByPrimaryKeySelective(user);
    }
}
