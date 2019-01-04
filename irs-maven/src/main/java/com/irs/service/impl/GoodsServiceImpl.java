package com.irs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.TbGoodsMapper;
import com.irs.pojo.TbGoods;
import com.irs.pojo.TbGoodsExample;
import com.irs.service.GoodsService;
import com.irs.util.ResultUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private TbGoodsMapper goodsMapper;
    @Override
    public ResultUtil selectGoods(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        TbGoodsExample example=new TbGoodsExample();
        //排序
        example.setOrderByClause("id DESC");
        TbGoodsExample.Criteria criteria = example.createCriteria();
        List<TbGoods> list = goodsMapper.selectByExample(example);
        PageInfo<TbGoods> pageInfo = new PageInfo<TbGoods>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public void addGoods(TbGoods goods) {

        goodsMapper.insert(goods);
    }

    @Override
    public void deleteGoodsById(Integer id) {
        goodsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteGoodsByIds(String goodsIds) {
        if(!StringUtils.isBlank(goodsIds)){
            String[] ids=goodsIds.split(",");
            for (String id : ids) {
                goodsMapper.deleteByPrimaryKey(Integer.parseInt(id));
            }
        }
    }

    @Override
    public TbGoods selectGoodsById(Integer id) {

        TbGoods goods=goodsMapper.selectByPrimaryKey(id);
        return goods;
    }

    @Override
    public void updateGoods(TbGoods goods) {

        goodsMapper.updateByPrimaryKeySelective(goods);
    }
}
