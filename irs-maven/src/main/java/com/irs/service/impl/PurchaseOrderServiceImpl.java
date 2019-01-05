package com.irs.service.impl;


import com.beust.jcommander.internal.Lists;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.*;
import com.irs.pojo.*;
import com.irs.service.PurchaseOrderService;
import com.irs.util.ResultUtil;
import com.irs.vo.PurchaseOrderVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
