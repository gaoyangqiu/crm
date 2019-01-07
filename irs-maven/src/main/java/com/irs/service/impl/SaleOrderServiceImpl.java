package com.irs.service.impl;

import com.beust.jcommander.internal.Lists;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.*;
import com.irs.pojo.*;
import com.irs.service.SaleOrderService;
import com.irs.util.ResultUtil;
import com.irs.vo.SaleOrderVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleOrderServiceImpl implements SaleOrderService {

    @Autowired
    private TbGoodsMapper goodsMapper;
    @Autowired
    private TbSupplierMapper supplierMapper;
    @Autowired
    private TbAdminMapper adminMapper;
    @Autowired
    private TbSaleOrderMapper saleOrderMapper;

    @Autowired
    private TbCustomerMapper customerMapper;
    @Override
    public ResultUtil selectSaleOrders(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        TbSaleOrderExample example=new TbSaleOrderExample();
        //排序
        example.setOrderByClause("id DESC");
        TbSaleOrderExample.Criteria criteria = example.createCriteria();
        List<TbSaleOrder> list = saleOrderMapper.selectByExample(example);
        List<SaleOrderVo> vos=converVo(list);
        PageInfo<SaleOrderVo> pageInfo = new PageInfo<SaleOrderVo>(vos);
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
    private List<SaleOrderVo> converVo(List<TbSaleOrder> list) {
        List<SaleOrderVo> vos = Lists.newArrayList();
        for (TbSaleOrder saleOrder : list) {
            SaleOrderVo vo = new SaleOrderVo();
            BeanUtils.copyProperties(saleOrder, vo);
            TbCustomer customer=customerMapper.selectByPrimaryKey(saleOrder.getCustomerId());
            //根据商品的ID查询出来采购单的商品
            TbGoods goods = goodsMapper.selectByPrimaryKey(saleOrder.getType());
            //根据供应商的ID查询出来采购单的供应商
            TbSupplier supplier = supplierMapper.selectByPrimaryKey(saleOrder.getSupplierId());
            //根据用户的id查询出来经办人
            TbAdmin user = adminMapper.selectByPrimaryKey(saleOrder.getSticks().longValue());
            //查询出来的商品名称放入vo
            vo.setGoodsName(goods.getName());
            vo.setSupplierName(supplier.getName());
            vo.setUserName(user.getUsername());
            vo.setCustomerName(customer.getName());
            vos.add(vo);
        }
        return vos;
    }
    @Override
    public void addSaleOrdere(TbSaleOrder saleOrder) {
        saleOrderMapper.insert(saleOrder);
    }

    @Override
    public void deleteSaleOrderById(Integer id) {
        saleOrderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteSaleOrdersByIds(String saleOrderIds) {
        if(!StringUtils.isBlank(saleOrderIds)){
            String[] ids=saleOrderIds.split(",");
            for (String id : ids) {
                saleOrderMapper.deleteByPrimaryKey(Integer.parseInt(id));
            }
        }
    }

    @Override
    public TbSaleOrder selectSaleOrderById(Integer id) {
        TbSaleOrder tbSaleOrder=saleOrderMapper.selectByPrimaryKey(id);
        return tbSaleOrder;
    }

    @Override
    public void updateSaleOrder(TbSaleOrder saleOrder) {
        saleOrderMapper.updateByPrimaryKeySelective(saleOrder);
    }
}
