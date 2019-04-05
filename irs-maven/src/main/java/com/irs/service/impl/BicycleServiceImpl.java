package com.irs.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.irs.mapper.TbBicycleMapper;
import com.irs.pojo.TbBicycle;
import com.irs.pojo.TbBicycleExample;
import com.irs.service.BicycleService;
import com.irs.service.enumt.BicycleType;
import com.irs.util.ResultUtil;
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
    public void addBicycle(TbBicycle bicycle) {

        bicycle.setDeflag(1);
        bicycle.setStatus(1);
        tbBicycleMapper.insertSelective(bicycle);
    }

    @Override
    public ResultUtil selectBicycles(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        TbBicycleExample example=new TbBicycleExample();
        example.setOrderByClause("id DESC");
        TbBicycleExample.Criteria criteria = example.createCriteria();
        List<TbBicycle> tbBicycles=tbBicycleMapper.selectByExample(example);
        List<BicycleVo> bicycleVos=coverVo(tbBicycles);
        PageInfo<BicycleVo> pageInfo = new PageInfo<BicycleVo>(bicycleVos);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    private List<BicycleVo> coverVo(List<TbBicycle> tbBicycles) {
        List<BicycleVo> bicycleVos= Lists.newArrayList();
        for (TbBicycle bicycle : tbBicycles) {
            BicycleVo vo=new BicycleVo();
            BeanUtils.copyProperties(bicycle,vo);
            vo.setTypeName(BicycleType.getBicycleType(bicycle.getType()).getDesc());
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
        for (BicycleType bicycleType : BicycleType.values()) {
            BicycleTypeVo vo=new BicycleTypeVo();
            vo.setId(bicycleType.getType());
            vo.setName(bicycleType.getDesc());
            bicycleVos.add(vo);
        }
        return bicycleVos;
    }

    @Override
    public Integer seBicycleCountByType(Integer id) {
        TbBicycleExample bicycleExample=new TbBicycleExample();
        TbBicycleExample.Criteria criteria=bicycleExample.createCriteria() ;
         criteria.andTypeEqualTo(id.byteValue());
        List<TbBicycle> tbBicycles=tbBicycleMapper.selectByExample(bicycleExample);
        Integer cout=0;
        for (TbBicycle tbBicycle : tbBicycles) {
            cout=cout+ tbBicycle.getCount();
        }
        return cout;
    }
}
