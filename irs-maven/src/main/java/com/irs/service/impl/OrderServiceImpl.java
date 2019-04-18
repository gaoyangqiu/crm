package com.irs.service.impl;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.irs.mapper.TbBicycleMapper;
import com.irs.mapper.TbOrderMapper;
import com.irs.pojo.TbBicycle;
import com.irs.pojo.TbOrder;
import com.irs.pojo.TbOrderExample;
import com.irs.service.OrderService;
import com.irs.service.enumt.BicycleType;
import com.irs.vo.StatisticsBicycleMoneyVo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: qgy
 * @Date: 2019/4/5 15:03
 * @Description:
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private TbBicycleMapper bicycleMapper;

    @Autowired
    private TbOrderMapper orderMapper;
    @Override
    public List<StatisticsBicycleMoneyVo> statisticsBicycleMoneyVoList() {
        List<StatisticsBicycleMoneyVo> statisticsBicycleMoneyVos=Lists.newArrayList();
        for (BicycleType bicycleType : BicycleType.values()) {
            StatisticsBicycleMoneyVo vo=new StatisticsBicycleMoneyVo();
            List<TbBicycle> bicycles=bicycleMapper.selectByType(bicycleType.getType());
            List<Integer> bicucleIds= Lists.transform(bicycles, new Function<TbBicycle, Integer>() {
                @Override
                public Integer apply(TbBicycle input) {
                    return input.getId();
                }
            });
            TbOrderExample tbOrderExample=new TbOrderExample();
            TbOrderExample.Criteria criteria1=tbOrderExample.createCriteria();
            criteria1.andTbBicycleIdIn(bicucleIds);
            List<TbOrder> tbOrders=orderMapper.selectByExample(tbOrderExample);
            Integer cout=0;
            if (CollectionUtils.isNotEmpty(tbOrders)){
                for (TbOrder tbOrder : tbOrders) {
                     cout=tbOrder.getTotalPrice().intValue()+cout;
                }
            }
            vo.setValue(cout);
            vo.setName(bicycleType.getDesc());
            statisticsBicycleMoneyVos.add(vo);
        }
        return statisticsBicycleMoneyVos;
    }
}
