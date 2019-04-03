package com.irs.service.impl;

import com.carrental.dao.BicycleMapper;
import com.carrental.entity.Bicycle;
import com.carrental.shopping.service.BicycleService;
import com.carrental.shopping.service.enumt.BicycleType;
import com.carrental.shopping.service.vo.BicycleTypeVo;
import com.carrental.shopping.vo.BicycleEditVo;
import com.carrental.shopping.vo.BicycleVo;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: qgy
 * @Date: 2019/3/31 23:53
 * @Description:
 */
@Service
public class BicycleServiceImpl implements BicycleService {

    @Autowired
    private BicycleMapper bicycleMapper;
    @Override
    public List<BicycleVo> bicycleList() {
        List<Bicycle> bicycles=bicycleMapper.findAll();
        List<BicycleVo> bicycleVos= Lists.newArrayList();
        for (Bicycle bicycle : bicycles) {
            BicycleVo vo=new BicycleVo();
            BeanUtils.copyProperties(bicycle,vo);
            vo.setTypeName(BicycleType.getBicycleType(bicycle.getType()).getDesc());
            bicycleVos.add(vo);
        }
        return bicycleVos;
    }

    @Override
    public void deleteBicycle( Integer id) {
        bicycleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void editBicycle(BicycleEditVo editVo) {
        bicycleMapper.updateByPrimaryKeySelective(editVo);
    }

    @Override
    public void addBicycle(BicycleEditVo editVo) {
        //时间不足,属性无法从页面添加暂时写死
        editVo.setDeflag(1);
        editVo.setStatus(1);
        editVo.setType(1);
        bicycleMapper.insertSelective(editVo);
    }

    @Override
    public List<BicycleTypeVo> bicycleType() {
        List<BicycleTypeVo> bicycleVos=Lists.newArrayList();
        for (BicycleType bicycleType : BicycleType.values()) {
            BicycleTypeVo vo=new BicycleTypeVo();
            vo.setId(bicycleType.getType());
            vo.setName(bicycleType.getDesc());
            bicycleVos.add(vo);
        }
        return bicycleVos;
    }
}
