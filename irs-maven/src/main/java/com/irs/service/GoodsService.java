package com.irs.service;


import com.irs.pojo.TbGoods;
import com.irs.util.ResultUtil;

public interface GoodsService {


    ResultUtil selectGoods(Integer page, Integer limit);

    void addGoods(TbGoods goods);

    void deleteGoodsById(Integer id);

    void deleteGoodsByIds(String goodsIds);

    TbGoods selectGoodsById(Integer id);

    void updateGoods(TbGoods goods);
}
