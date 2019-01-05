package com.irs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.TbSupplierMapper;
import com.irs.pojo.TbSupplier;
import com.irs.pojo.TbSupplierExample;
import com.irs.service.SupplierService;
import com.irs.util.ResultUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SupplierServiceImpl implements SupplierService {


    @Autowired
    private TbSupplierMapper supplierMapper;
    @Override
    public ResultUtil selectSupplies(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        TbSupplierExample example=new TbSupplierExample();
        //排序
        example.setOrderByClause("id DESC");
        TbSupplierExample.Criteria criteria = example.createCriteria();
        List<TbSupplier> list = supplierMapper.selectByExample(example);
        PageInfo<TbSupplier> pageInfo = new PageInfo<TbSupplier>(list);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public void addSupplie(TbSupplier supplier) {
        supplierMapper.insert(supplier);
    }

    @Override
    public void deleteSupplieById(Integer id) {
        supplierMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteSuppliesByIds(String supplieIds) {
        if(!StringUtils.isBlank(supplieIds)){
            String[] ids=supplieIds.split(",");
            for (String id : ids) {
                supplierMapper.deleteByPrimaryKey(Integer.parseInt(id));
            }
        }
    }

    @Override
    public TbSupplier selectSupplieById(Integer id) {
        TbSupplier supplier=supplierMapper.selectByPrimaryKey(id);
        return supplier;
    }

    @Override
    public void updateSupplie(TbSupplier supplier) {
        supplierMapper.updateByPrimaryKeySelective(supplier);
    }
}
