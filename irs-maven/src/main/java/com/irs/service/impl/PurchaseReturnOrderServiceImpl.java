package com.irs.service.impl;


import com.beust.jcommander.internal.Lists;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.TbAdminMapper;
import com.irs.mapper.TbGoodsMapper;
import com.irs.mapper.TbPurchaseReturnOrderMapper;
import com.irs.mapper.TbSupplierMapper;
import com.irs.pojo.*;
import com.irs.service.PurchaseReturnOrderService;
import com.irs.util.ResultUtil;
import com.irs.vo.PurchaseOrderVo;
import com.irs.vo.PurchaseReturnOrderVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseReturnOrderServiceImpl implements PurchaseReturnOrderService {
    @Autowired
    private TbPurchaseReturnOrderMapper purchaseReturnOrderMapper;
    @Autowired
    private TbGoodsMapper goodsMapper;
    @Autowired
    private TbSupplierMapper supplierMapper;
    @Autowired
    private TbAdminMapper adminMapper;
    @Override
    public ResultUtil selectPurchaseReturnOrders(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        TbPurchaseReturnOrderExample example=new TbPurchaseReturnOrderExample();
        //排序
        example.setOrderByClause("id DESC");
        TbPurchaseReturnOrderExample.Criteria criteria = example.createCriteria();
        List<TbPurchaseReturnOrder> list = purchaseReturnOrderMapper.selectByExample(example);
        List<PurchaseReturnOrderVo> vos=converVo(list);
        PageInfo<PurchaseReturnOrderVo> pageInfo = new PageInfo<PurchaseReturnOrderVo>(vos);
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
    private List<PurchaseReturnOrderVo> converVo(List<TbPurchaseReturnOrder> list) {
        List<PurchaseReturnOrderVo> vos= Lists.newArrayList();
        for (TbPurchaseReturnOrder purchaseOrder : list) {
            PurchaseReturnOrderVo vo=new PurchaseReturnOrderVo();
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
    public void addPurchaseReturnOrder(TbPurchaseReturnOrder purchaseOrder) {
        purchaseReturnOrderMapper.insert(purchaseOrder);
    }

    @Override
    public void deletePurchaseReturnOrderById(Integer id) {
        purchaseReturnOrderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deletePurchaseReturnOrdersByIds(String supplieIds) {
        if(!StringUtils.isBlank(supplieIds)){
            String[] ids=supplieIds.split(",");
            for (String id : ids) {
                purchaseReturnOrderMapper.deleteByPrimaryKey(Integer.parseInt(id));
            }
        }
    }

    @Override
    public TbPurchaseReturnOrder selectPurchaseReturnOrderById(Integer id) {
        TbPurchaseReturnOrder returnOrder=purchaseReturnOrderMapper.selectByPrimaryKey(id);
        return returnOrder;
    }

    @Override
    public void updatePurchaseReturnOrder(TbPurchaseReturnOrder returnOrder) {
        purchaseReturnOrderMapper.updateByPrimaryKeySelective(returnOrder);
    }

}
