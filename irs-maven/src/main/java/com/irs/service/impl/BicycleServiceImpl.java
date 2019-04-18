package com.irs.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.irs.mapper.TbBicycleMapper;
import com.irs.mapper.TbBicycleTypeMapper;
import com.irs.mapper.TbPlacementMapper;
import com.irs.pojo.TbBicycle;
import com.irs.pojo.TbBicycleType;
import com.irs.pojo.TbPlacement;
import com.irs.service.BicycleService;
import com.irs.service.enumt.BicycleType;
import com.irs.util.ResultUtil;
import com.irs.vo.BicycleSaveVo;
import com.irs.vo.BicycleTypeVo;
import com.irs.vo.BicycleVo;
import org.apache.commons.lang.StringUtils;
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
    private TbBicycleMapper tbBicycleMapper;
    @Autowired
    private TbBicycleTypeMapper tbBicycleTypeMapper;

    @Autowired
    private TbPlacementMapper tbPlacementMapper;
    @Override
    public TbBicycle selectBicycleById(Integer id) {

        return  tbBicycleMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateSupplie(TbBicycle bicycle) {
        tbBicycleMapper.updateByPrimaryKeySelective(bicycle);
    }

    @Override
    public void deleteSuppliesByIds(String supplierStr) {
        if(!StringUtils.isBlank(supplierStr)){
            String[] ids=supplierStr.split(",");
            for (String id : ids) {
                tbBicycleMapper.deleteByPrimaryKey(Integer.parseInt(id));
            }
        }
    }

    @Override
    public void deleteSupplieById(Integer id) {
        tbBicycleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void addBicycle(BicycleSaveVo bicycle) {
        //查询放置点的单车数量,并修改
        TbPlacement tbPlacement=tbPlacementMapper.selectByPrimaryKey(bicycle.getPlacement());
        tbPlacement.setCount(tbPlacement.getCount()+bicycle.getCount());
        tbPlacementMapper.updateByPrimaryKeySelective(tbPlacement);
        //查询单车类型的单车数量,并修改
        TbBicycleType tbBicycleType=tbBicycleTypeMapper.selectByPrimaryKey(bicycle.getType());
        tbBicycleType.setCount(tbBicycleType.getCount()+bicycle.getCount());
        tbBicycleTypeMapper.updateByPrimaryKeySelective(tbBicycleType);
        //根据添加单车的数量生成单车模型
        int index=1;
        for (int i=0;i<bicycle.getCount();i++) {
            TbBicycle tbBicycle=new TbBicycle();
            tbBicycle.setDeflag(0);
            tbBicycle.setStatus(0);
            tbBicycle.setNumber(bicycle.getType()*10000+index);
            tbBicycle.setPrice(bicycle.getPrice());
            tbBicycle.setType(bicycle.getType());
            tbBicycle.setPlacement(bicycle.getPlacement());
            tbBicycleMapper.insertSelective(tbBicycle);
            index++;
        }

    }

    @Override
    public ResultUtil selectBicycles(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<TbBicycle> tbBicycles=tbBicycleMapper.selectByOrderDesc();
        PageInfo<TbBicycle> pageInfo = new PageInfo<TbBicycle>(tbBicycles);
        List<BicycleVo> bicycleVos=coverVo(tbBicycles);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(bicycleVos);
        return resultUtil;
    }

    private List<BicycleVo> coverVo(List<TbBicycle> tbBicycles) {
        List<BicycleVo> bicycleVos= Lists.newArrayList();
        for (TbBicycle bicycle : tbBicycles) {
            BicycleVo vo=new BicycleVo();
            BeanUtils.copyProperties(bicycle,vo);
            TbBicycleType tbBicycleType=tbBicycleTypeMapper.selectByPrimaryKey(bicycle.getType());
            TbPlacement tbPlacement=tbPlacementMapper.selectByPrimaryKey(bicycle.getPlacement());
            vo.setTypeName(tbBicycleType.getName());
            vo.setPlacementName(tbPlacement.getName());
            bicycleVos.add(vo);
        }
        return bicycleVos;
    }

/*    @Autowired
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
*/
    @Override
    public List<BicycleTypeVo> bicycleType() {
        List<BicycleTypeVo> bicycleVos=Lists.newArrayList();
        List<TbBicycleType> tbBicycleTypes=tbBicycleTypeMapper.selectAll();
        for (TbBicycleType bicycleType : tbBicycleTypes) {
            BicycleTypeVo vo=new BicycleTypeVo();
            vo.setId(bicycleType.getId());
            vo.setName(bicycleType.getName());
            bicycleVos.add(vo);
        }
        return bicycleVos;
    }

    @Override
    public List<TbPlacement> placements() {
        List<TbPlacement> tbPlacements=tbPlacementMapper.selectAll();
        return tbPlacements;
    }

    @Override
    public Integer seBicycleCountByType(Integer id) {
        List<TbBicycle> tbBicycles=tbBicycleMapper.selectByType(id);
        Integer cout=0;
        return cout;
    }
}
