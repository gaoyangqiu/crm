package com.irs.service.impl;

import com.beust.jcommander.internal.Lists;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.*;
import com.irs.pojo.*;
import com.irs.service.SaleReturnOrderService;
import com.irs.util.ResultUtil;
import com.irs.vo.SaleReturnOrderVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SaleReturnOrderServiceImpl implements SaleReturnOrderService {

    @Autowired
    private TbSaleReturnOrderMapper saleReturnOrderMapper;
    @Autowired
    private TbGoodsMapper goodsMapper;
    @Autowired
    private TbSupplierMapper supplierMapper;
    @Autowired
    private TbAdminMapper adminMapper;
    @Autowired
    private TbCustomerMapper customerMapper;
    @Override
    public ResultUtil selectSaleReturnOrders(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        TbSaleReturnOrderExample example=new TbSaleReturnOrderExample();
        //排序
        example.setOrderByClause("id DESC");
        TbSaleReturnOrderExample.Criteria criteria = example.createCriteria();
        List<TbSaleReturnOrder> list = saleReturnOrderMapper.selectByExample(example);
        List<SaleReturnOrderVo> vos=converVo(list);
        PageInfo<SaleReturnOrderVo> pageInfo = new PageInfo<SaleReturnOrderVo>(vos);
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
    private List<SaleReturnOrderVo> converVo( List<TbSaleReturnOrder> list) {
        List<SaleReturnOrderVo> vos= Lists.newArrayList();
        for (TbSaleReturnOrder purchaseOrder : list) {
            SaleReturnOrderVo vo=new SaleReturnOrderVo();
            BeanUtils.copyProperties(purchaseOrder,vo);
            TbCustomer customer=customerMapper.selectByPrimaryKey(purchaseOrder.getCustomerId());
            //根据商品的ID查询出来采购单的商品
            TbGoods goods=goodsMapper.selectByPrimaryKey(purchaseOrder.getType());
            //根据供应商的ID查询出来采购单的供应商
            TbSupplier supplier=supplierMapper.selectByPrimaryKey(purchaseOrder.getSupplierId());
            //根据用户的id查询出来经办人
            TbAdmin user=adminMapper.selectByPrimaryKey(purchaseOrder.getSticks().longValue());
            //查询出来的商品名称放入vo
            BigDecimal money=purchaseOrder.getSalePrice().multiply(BigDecimal.valueOf(purchaseOrder.getAmount().longValue()));
            vo.setGoodsName(goods.getName());
            vo.setSupplierName(supplier.getName());
            vo.setUserName(user.getUsername());
            vo.setCustomerName(customer.getName());
            vo.setMoney(money);
            vos.add(vo);
        }
        return vos;
    }
    @Override
    public void addSaleReturnOrder(TbSaleReturnOrder saleReturnOrder) {

        saleReturnOrderMapper.insert(saleReturnOrder);
    }

    @Override
    public void deleteSaleReturnOrderById(Integer id) {
        saleReturnOrderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteSaleReturnOrdersByIds(String supplieIds) {
        if(!StringUtils.isBlank(supplieIds)){
            String[] ids=supplieIds.split(",");
            for (String id : ids) {
                saleReturnOrderMapper.deleteByPrimaryKey(Integer.parseInt(id));
            }
        }
    }

    @Override
    public TbSaleReturnOrder selectSaleReturnOrderById(Integer id) {
        TbSaleReturnOrder saleReturnOrder=saleReturnOrderMapper.selectByPrimaryKey(id);
        return saleReturnOrder;
    }

    @Override
    public void updateSaleReturnOrder(TbSaleReturnOrder returnOrder) {
        saleReturnOrderMapper.updateByPrimaryKeySelective(returnOrder);
    }
}
