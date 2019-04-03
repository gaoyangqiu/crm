package com.irs.service;

import com.carrental.shopping.service.vo.BicycleTypeVo;
import com.carrental.shopping.vo.BicycleEditVo;
import com.carrental.shopping.vo.BicycleVo;

import java.util.List;

/**
 * @Author: qgy
 * @Date: 2019/3/31 23:53
 * @Description:
 */

public interface BicycleService {

    List<BicycleVo> bicycleList();

    void deleteBicycle(Integer id);

    void editBicycle(BicycleEditVo editVo);

    void addBicycle(BicycleEditVo editVo);

    List<BicycleTypeVo> bicycleType();

}
