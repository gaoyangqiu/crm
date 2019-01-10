package com.irs.service.impl;


import com.beust.jcommander.internal.Lists;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.TbGoodsMapper;
import com.irs.mapper.TbGoodsTypeMapper;
import com.irs.mapper.TbStockMapper;
import com.irs.mapper.TbSupplierMapper;
import com.irs.pojo.*;
import com.irs.service.StockService;
import com.irs.util.ResultUtil;
import com.irs.vo.StockVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private TbStockMapper stockMapper;
    @Autowired
    private TbGoodsMapper goodsMapper;
    @Autowired
    private TbGoodsTypeMapper goodsTypeMapper;
    @Autowired
    private TbSupplierMapper supplierMapper;
    @Override
    public ResultUtil selectStock(Integer page, Integer limit,Integer type) {
        PageHelper.startPage(page, limit);
        TbStockExample example=new TbStockExample();
        //排序
        example.setOrderByClause("id DESC");
        TbStockExample.Criteria criteria = example.createCriteria();
        List<TbStock> list = stockMapper.selectByExample(example);
        List<StockVo> vos=converVo(list, type);
        List<StockVo> shortage=Lists.newArrayList();
        PageInfo<StockVo> pageInfo =null;
        if (null!=type&&1==type){
            for (StockVo vo : vos) {
                if(null!=vo.getCordon()&&vo.getAmount().compareTo(vo.getCordon())==-1) {
                    vo.setCordonStatus(0);
                    shortage.add(vo);
                }
            }
            pageInfo=new PageInfo<StockVo>(shortage);
        }else if(null!=type&&2==type){
            for (StockVo vo : vos) {
                if(null!=vo.getCordon()&&vo.getAmount().compareTo(vo.getCordon())==-1) {
                    vo.setCordonStatus(2);
                    shortage.add(vo);
                }
            }
            pageInfo=new PageInfo<StockVo>(shortage);
        }else {
            pageInfo=new PageInfo<StockVo>(vos);
        }

        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    /**
     * 查询出来的do转化vo
     * @param list
     * @return
     */
    private List<StockVo> converVo(List<TbStock> list,Integer type) {
        List<StockVo> vos = Lists.newArrayList();
        for (TbStock stock : list) {
            StockVo vo=new StockVo();
            TbGoods goods=goodsMapper.selectByPrimaryKey(stock.getGoodsId());
            //设置警戒状态
            //大于警戒值
/*            if (null!=stock.getCordon()&&stock.getAmount().compareTo(stock.getCordon())==1){
                vo.setCordonStatus(2);
                //小于警戒值
            }else if(null!=stock.getCordon()&&stock.getAmount().compareTo(stock.getCordon())==-1){
                vo.setCordonStatus(0);
                //等于警戒值
            }else if (null!=stock.getCordon()&&stock.getAmount().compareTo(stock.getCordon())==0){
                vo.setCordonStatus(1);
            }*/
            BeanUtils.copyProperties(stock,vo);
            TbGoodsType goodsType=goodsTypeMapper.selectByPrimaryKey(goods.getGoodsType());
            TbSupplier supplier=supplierMapper.selectByPrimaryKey(goods.getSuppliersId());
            vo.setGoodsTypeName(goodsType.getName());
            vo.setSupplierName(supplier.getName());
            vo.setGoods(goods);
            vo.setHome(goods.getHome());
            vo.setPrice(goods.getPrice());
            vo.setName(goods.getName());
            vos.add(vo);
        }
        return vos;
    }
    @Override
    public void addStock(TbStock stock) {
        stockMapper.insert(stock);
    }

    @Override
    public void deleteStocskByIds(String stockIds) {
        if(!StringUtils.isBlank(stockIds)){
            String[] ids=stockIds.split(",");
            for (String id : ids) {
                stockMapper.deleteByPrimaryKey(Integer.parseInt(id));
            }
        }
    }

    @Override
    public TbStock selectStockById(Integer id) {
        TbStock stock=stockMapper.selectByPrimaryKey(id);
        return stock;
    }

    @Override
    public void updateStock(TbStock stock) {
        stockMapper.updateByPrimaryKey(stock);
        //更新库存价格的同时更新商品价格
/*        TbGoodsExample tbGoodsExample=new TbGoodsExample();
        TbGoodsExample.Criteria criteria=tbGoodsExample.createCriteria();
        criteria.andPriceEqualTo(stock.getPrice());*/
        TbGoods goods=new TbGoods();
        goods.setId(stock.getGoodsId());
        goods.setPrice(stock.getPrice());
        goodsMapper.updateByPrimaryKeySelective(goods);
    }

    @Override
    public ResultUtil searchShortage(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        TbStockExample example=new TbStockExample();
        //排序
        example.setOrderByClause("id DESC");
        TbStockExample.Criteria criteria = example.createCriteria();
        List<TbStock> list = stockMapper.selectByExample(example);
        List<StockVo> vos=converVo(list,null);
        List<StockVo> shortage=Lists.newArrayList();
        for (StockVo vo : vos) {
            if(null!=vo.getCordon()&&vo.getAmount().compareTo(vo.getCordon())==-1) {
                vo.setCordonStatus(0);
                shortage.add(vo);
            }
        }
        PageInfo<StockVo> pageInfo = new PageInfo<StockVo>(shortage);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }
}
