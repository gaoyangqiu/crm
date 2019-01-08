package com.irs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.TbGoodsTypeMapper;
import com.irs.pojo.TbGoodsType;
import com.irs.pojo.TbGoodsTypeExample;
import com.irs.service.GoodsTypeService;
import com.irs.util.ResultUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired
    private TbGoodsTypeMapper goodsTypeMapper;
    @Override
    public ResultUtil selectGoodsType(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        TbGoodsTypeExample example=new TbGoodsTypeExample();
        //排序
        example.setOrderByClause("id DESC");
        TbGoodsTypeExample.Criteria criteria = example.createCriteria();
        List<TbGoodsType> list = goodsTypeMapper.selectByExample(example);
        PageInfo<TbGoodsType> pageInfo = new PageInfo<TbGoodsType>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public void addGoodsType(TbGoodsType goodsType) {

        goodsTypeMapper.insert(goodsType);
    }

    @Override
    public void deleteStocskByIds(String goodsTypeIds) {
        if(!StringUtils.isBlank(goodsTypeIds)){
            String[] ids=goodsTypeIds.split(",");
            for (String id : ids) {
                goodsTypeMapper.deleteByPrimaryKey(Integer.parseInt(id));
            }
        }
    }

    @Override
    public TbGoodsType selectGoodsTypeById(Integer id) {
        TbGoodsType goodsType=goodsTypeMapper.selectByPrimaryKey(id);
        return goodsType;
    }

    @Override
    public void updateGoodsType(TbGoodsType goodsType) {
        goodsTypeMapper.updateByPrimaryKeySelective(goodsType);
    }

    @Override
    public void deleteGoodsTypeByid(Integer id) {
        goodsTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<TbGoodsType> selectGoodsTypes() {
        TbGoodsTypeExample example=new TbGoodsTypeExample();
        List<TbGoodsType> tbGoodsTypes=goodsTypeMapper.selectByExample(example);
        return tbGoodsTypes;
    }
}
