package com.irs.service;

import com.irs.pojo.TbBicycle;
import com.irs.util.ResultUtil;
import com.irs.vo.BicycleTypeVo;

import java.util.List;

/**
 * @Author: qgy
 * @Date: 2019/3/31 23:53
 * @Description:
 */

public interface BicycleService {



    TbBicycle selectBicycleById(Integer id);

    void updateSupplie(TbBicycle bicycle);

    void deleteSuppliesByIds(String supplierStr);

    void deleteSupplieById(Integer id);

    void addBicycle(TbBicycle bicycle);

    ResultUtil selectBicycles(Integer page, Integer limit);


    List<BicycleTypeVo> bicycleType();

    Integer seBicycleCountByType(Integer id);
}
