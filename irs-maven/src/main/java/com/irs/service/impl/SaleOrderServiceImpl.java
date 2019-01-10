package com.irs.service.impl;

import com.beust.jcommander.internal.Lists;
import com.beust.jcommander.internal.Maps;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.*;
import com.irs.pojo.*;
import com.irs.service.SaleOrderService;
import com.irs.util.ResultUtil;
import com.irs.vo.SaleOrderVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

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

    @Autowired
    private TbStockMapper stockMapper;
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

        //销售的时候对对应商品的库存进行减少
        TbStockExample stockExample=new TbStockExample();
        TbStockExample.Criteria criteria=stockExample.createCriteria();
        criteria.andGoodsIdEqualTo(saleOrder.getType());
        //根据采购单的商品id查询到对应的库存
        List<TbStock> stocks=stockMapper.selectByExample(stockExample);
        //数据库设置的库存的goodsId为唯一,一个商品对应一条库存记录,所以直接get0
        if (CollectionUtils.isNotEmpty(stocks)){
            TbStock stock= stocks.get(0);
            //更新库存的数量
            stock.setAmount(stock.getAmount().subtract(new BigDecimal(saleOrder.getAmount().toString())));
            stockMapper.updateByPrimaryKey(stock);
        }
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

    @Override
    public ResultUtil queryStatistics() {
/*        TbSaleOrderExample example=new TbSaleOrderExample();
        //排序
        example.setOrderByClause("id DESC");
        List<TbSaleOrder> list = saleOrderMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)){
            return null;
        }
        //查询出来的list根据销售额排序
        Collections.sort(list, new Comparator<TbSaleOrder>() {
            @Override
            public int compare(TbSaleOrder o1, TbSaleOrder o2) {
                return o2.getSalePrice().multiply(new BigDecimal(o2.getAmount())).subtract(o1.getSalePrice().multiply(new BigDecimal(o1.getAmount()))).intValue();
            }
        });
        List<SaleOrderVo> converVos=converVo(list);
        if (CollectionUtils.isEmpty(converVos)){
            return null;
        }
        //组装柱状图的数据
        List<String> xAxis=Lists.newArrayList();
        List<BigDecimal> datas=Lists.newArrayList();
        for (SaleOrderVo converVo : converVos) {
            xAxis.add(converVo.getGoodsName());
            datas.add(converVo.getSalePrice().multiply(new BigDecimal(converVo.getAmount())));
        }
        Map map=Maps.newHashMap();
        map.put("xAxis",xAxis);
        map.put("datas",datas);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setData(map);
        return resultUtil;*/
        return null;
    }
}
