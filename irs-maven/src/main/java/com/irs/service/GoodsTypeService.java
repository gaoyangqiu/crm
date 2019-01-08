package com.irs.service;


import com.irs.pojo.TbGoodsType;
import com.irs.util.ResultUtil;

import java.util.List;

public interface GoodsTypeService {


    ResultUtil selectGoodsType(Integer page, Integer limit);

    void addGoodsType(TbGoodsType goodsType);


    void deleteStocskByIds(String goodsTypeIds);

    TbGoodsType selectGoodsTypeById(Integer id);

    void updateGoodsType(TbGoodsType goodsType);

    void deleteGoodsTypeByid(Integer id);

    List<TbGoodsType> selectGoodsTypes();
}
