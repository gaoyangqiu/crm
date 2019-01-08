package com.irs.service.impl;


import com.beust.jcommander.internal.Lists;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.*;
import com.irs.pojo.*;
import com.irs.service.PurchaseOrderService;
import com.irs.util.ResultUtil;
import com.irs.vo.PurchaseOrderVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    @Autowired
    private TbPurchaseOrderMapper purchaseOrderMapper;
    @Autowired
    private TbGoodsMapper goodsMapper;
    @Autowired
    private TbSupplierMapper supplierMapper;
    @Autowired
    private TbAdminMapper adminMapper;
    @Autowired
    private TbStockMapper stockMapper;
    @Override
    public ResultUtil selectPurchaseOrders(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        TbPurchaseOrderExample example=new TbPurchaseOrderExample();
        //排序
        example.setOrderByClause("id DESC");
        TbPurchaseOrderExample.Criteria criteria = example.createCriteria();
        List<TbPurchaseOrder> list = purchaseOrderMapper.selectByExample(example);
        List<PurchaseOrderVo> vos=converVo(list);
        PageInfo<PurchaseOrderVo> pageInfo = new PageInfo<PurchaseOrderVo>(vos);
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
    private List<PurchaseOrderVo> converVo(List<TbPurchaseOrder> list) {
        List<PurchaseOrderVo> vos=Lists.newArrayList();
        for (TbPurchaseOrder purchaseOrder : list) {
            PurchaseOrderVo vo=new PurchaseOrderVo();
            BeanUtils.copyProperties(purchaseOrder,vo);
            //根据商品的ID查询出来采购单的商品
            TbGoods goods=goodsMapper.selectByPrimaryKey(purchaseOrder.getType());
            //根据供应商的ID查询出来采购单的供应商
            TbSupplier supplier=supplierMapper.selectByPrimaryKey(purchaseOrder.getSupplier());
            //根据用户的id查询出来经办人
            TbAdmin user=adminMapper.selectByPrimaryKey(purchaseOrder.getSticks().longValue());
            //查询出来的商品名称放入vo
            vo.setGoodsName(goods.getName());
            vo.setSupplierName(supplier.getName());
            vo.setUserName(user.getUsername());
            vos.add(vo);
        }
        return vos;
    }

    @Override
    public void addPurchaseOrdere(TbPurchaseOrder purchaseOrder) {
        //采购的时候对对应商品的库存进行添加
        TbStockExample stockExample=new TbStockExample();
        TbStockExample.Criteria criteria=stockExample.createCriteria();
        criteria.andGoodsIdEqualTo(purchaseOrder.getType());
        //根据采购单的商品id查询到对应的库存
        List<TbStock> stocks=stockMapper.selectByExample(stockExample);
        //数据库设置的库存的goodsId为唯一,一个商品对应一条库存记录,所以直接get0
        if (CollectionUtils.isNotEmpty(stocks)){
            TbStock stock= stocks.get(0);
            //更新库存的数量
            stock.setAmount(stock.getAmount().add(new BigDecimal(purchaseOrder.getAmount().toString())));
            stockMapper.updateByPrimaryKey(stock);
        }

        purchaseOrderMapper.insert(purchaseOrder);
    }

    @Override
    public void deletePurchaseOrderById(Integer id) {
        purchaseOrderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deletePurchaseOrdersByIds(String supplieIds) {
        if(!StringUtils.isBlank(supplieIds)){
            String[] ids=supplieIds.split(",");
            for (String id : ids) {
                purchaseOrderMapper.deleteByPrimaryKey(Integer.parseInt(id));
            }
        }
    }

    @Override
    public TbPurchaseOrder selectPurchaseOrderById(Integer id) {
        TbPurchaseOrder purchaseOrder=purchaseOrderMapper.selectByPrimaryKey(id);
        return purchaseOrder;
    }

    @Override
    public void updatePurchaseOrder(TbPurchaseOrder purchaseOrder) {
        purchaseOrderMapper.updateByPrimaryKeySelective(purchaseOrder);
    }
}
