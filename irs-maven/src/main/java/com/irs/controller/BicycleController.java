package com.irs.controller;


import com.irs.annotation.SysLog;
import com.irs.pojo.TbBicycle;
import com.irs.pojo.TbSupplier;
import com.irs.service.BicycleService;
import com.irs.util.ResultUtil;
import com.irs.vo.BicycleEditVo;
import com.irs.vo.BicycleTypeVo;
import com.irs.vo.BicycleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: qgy
 * @Date: 2019/3/31 23:47
 * @Description:
 */

@Controller
@RequestMapping("bicycle")
public class BicycleController {

    @Autowired
    private BicycleService bicycleService;

    @RequestMapping("/bicycleList")
    public String supplierList() {
        return "page/bicycle/bicycleList";
    }


    @RequestMapping("/addbicycle")
    public String addSupplier(Model model) {
        List<BicycleTypeVo> bicycleTypeVos=bicycleService.bicycleType();
        model.addAttribute("bicycleTypeVos",bicycleTypeVos);
        return "page/bicycle/addbicycle";
    }


    @RequestMapping("/editSupplier")
    public String editSupplier(Integer id,Model model) {
        TbBicycle bicycle=bicycleService.selectBicycleById(id);
        List<BicycleTypeVo> bicycleTypeVos=bicycleService.bicycleType();
        model.addAttribute("bicycle",bicycle);
        model.addAttribute("bicycleTypeVos",bicycleTypeVos);
        return "page/bicycle/editsupplier";
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResultUtil getSupplierList(Integer page,Integer limit) {
        ResultUtil suppliers = bicycleService.selectBicycles(page, limit);
        return suppliers;
    }

    /**
     * 添加供应商信息
     * @param bicycle
     * @return
     */
    @SysLog(value="添加供应商信息")
    @RequestMapping("/save")
    @ResponseBody
    public ResultUtil insSupplier(TbBicycle bicycle) {
        try {
            bicycleService.addBicycle(bicycle);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("添加出错,稍后再试！");
        }
    }


    /**
     * 删除指定供应商信息
     * @param id
     * @return
     */
    @SysLog(value="删除供应商信息")
    @RequestMapping("/delete")
    @ResponseBody
    public ResultUtil delSupplierById(Integer id) {
        try {
            bicycleService.deleteSupplieById(id);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("修改出错,稍后再试！");
        }
    }

    /**
     * 批量删除供应商信息
     * @param supplierStr
     * @return
     */
    @SysLog(value="批量删除供应商信息")
    @RequestMapping("/deletes")
    @ResponseBody
    public ResultUtil delSupplier(String supplierStr) {
        try {
            bicycleService.deleteSuppliesByIds(supplierStr);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("删除出错,稍后再试！");
        }
    }

    /**
     * 供应商信息
     * @param bicycle
     * @return
     */
    @SysLog(value="更新供应商信息")
    @RequestMapping("/update")
    @ResponseBody
    public ResultUtil updateSupplier(TbBicycle bicycle) {
        try {

            bicycleService.updateSupplie(bicycle);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("删除出错,稍后再试！");
        }
    }

}
