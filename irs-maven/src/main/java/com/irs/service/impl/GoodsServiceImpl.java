package com.irs.service.impl;

import com.beust.jcommander.internal.Lists;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.TbGoodsMapper;
import com.irs.mapper.TbGoodsTypeMapper;
import com.irs.mapper.TbStockMapper;
import com.irs.mapper.TbSupplierMapper;
import com.irs.pojo.*;
import com.irs.service.GoodsService;
import com.irs.util.ResultUtil;
import com.irs.vo.GoodsVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private TbGoodsMapper goodsMapper;
    @Autowired
    private TbSupplierMapper supplierMapper;
    @Autowired
    private TbGoodsTypeMapper goodsTypeMapper;
    @Autowired
    private TbStockMapper stockMapper;
    @Override
    public ResultUtil selectGoods(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        TbGoodsExample example=new TbGoodsExample();
        //排序
        example.setOrderByClause("id DESC");
        TbGoodsExample.Criteria criteria = example.createCriteria();
        List<TbGoods> list = goodsMapper.selectByExample(example);
        List<GoodsVo> vos=converVo(list);
        PageInfo<GoodsVo> pageInfo = new PageInfo<GoodsVo>(vos);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    private List<GoodsVo> converVo(List<TbGoods> list) {
        List<GoodsVo> goodsVos= Lists.newArrayList();
        for (TbGoods goods : list) {
            GoodsVo vo=new GoodsVo();
            //根据供应商的id查询出供应商,把供应商的name设置到vo里面
            if (null!=goods.getSuppliersId()){
                TbSupplier supplier=supplierMapper.selectByPrimaryKey(goods.getSuppliersId());
                vo.setSupplierName(supplier.getName());
            }
            //根据商品类型的id查询出来商品类型,把商品类型的name设置到vo里面
            if (null!=goods.getGoodsType()){
                TbGoodsType goodsType=goodsTypeMapper.selectByPrimaryKey(goods.getGoodsType());
                vo.setGoodsTypeName(goodsType.getName());
            }
            BeanUtils.copyProperties(goods,vo);
            goodsVos.add(vo);
        }
        return goodsVos;
    }

    @Override
    public void addGoods(TbGoods goods) {

        goodsMapper.insert(goods);
        //进行新建商品的时候初始化一个库存
        TbStock stock=new TbStock();
        //初始化库存的数量是0
        stock.setAmount(BigDecimal.ZERO);
        stock.setGoodsId(goods.getId());
        stock.setPrice(goods.getPrice());
        stockMapper.insertSelective(stock);

    }

    @Override
    public void deleteGoodsById(Integer id) {

        goodsMapper.deleteByPrimaryKey(id);
        //删除货物的时候删除对应的库存
        TbStockExample stockExample=new TbStockExample();
        TbStockExample.Criteria criteria=stockExample.createCriteria();
        criteria.andGoodsIdEqualTo(id);
        //根据采购单的商品id查询到对应的库存
        List<TbStock> stocks=stockMapper.selectByExample(stockExample);
        //数据库设置的库存的goodsId为唯一,一个商品对应一条库存记录,所以直接get0
        if (CollectionUtils.isNotEmpty(stocks)){
            TbStock stock= stocks.get(0);
         //删除库存
            stockMapper.deleteByPrimaryKey(stock.getId());
        }
    }

    @Override
    public void deleteGoodsByIds(String goodsIds) {
        if(!StringUtils.isBlank(goodsIds)){
            String[] ids=goodsIds.split(",");
            for (String id : ids) {
                goodsMapper.deleteByPrimaryKey(Integer.parseInt(id));
                //删除货物的时候删除对应的库存
                TbStockExample stockExample=new TbStockExample();
                TbStockExample.Criteria criteria=stockExample.createCriteria();
                criteria.andGoodsIdEqualTo(Integer.parseInt(id));
                //根据采购单的商品id查询到对应的库存
                List<TbStock> stocks=stockMapper.selectByExample(stockExample);
                //数据库设置的库存的goodsId为唯一,一个商品对应一条库存记录,所以直接get0
                if (CollectionUtils.isNotEmpty(stocks)){
                    TbStock stock= stocks.get(0);
                    //删除库存
                    stockMapper.deleteByPrimaryKey(stock.getId());
                }
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
