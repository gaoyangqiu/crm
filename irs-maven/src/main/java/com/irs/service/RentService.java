package com.irs.service;



import com.irs.pojo.TbBicycle;

import java.util.List;

/**
 * @Author: qgy
 * @Date: 2019/3/31 16:15
 * @Description:
 */
public interface RentService {

    List<TbBicycle> getRentListAll();

    RestResult createRent(CreateRentVo rentVo);

}
