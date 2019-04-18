package com.irs.controller;


import com.irs.annotation.SysLog;
import com.irs.pojo.TbBicycle;
import com.irs.pojo.TbPlacement;
import com.irs.service.BicycleService;
import com.irs.util.ResultUtil;
import com.irs.vo.BicycleSaveVo;
import com.irs.vo.BicycleTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String bicycleList() {
        return "page/bicycle/bicycleList";
    }


    @RequestMapping("/addBicycle")
    public String addBicycle(Model model) {
        List<BicycleTypeVo> bicycleTypeVos=bicycleService.bicycleType();
        List<TbPlacement> tbPlacements=bicycleService.placements();
        model.addAttribute("bicycleTypeVos",bicycleTypeVos);
        model.addAttribute("tbPlacements",tbPlacements);
        return "page/bicycle/addbicycle";
    }


    @RequestMapping("/editBicycle")
    public String editBicycle(Integer id,Model model) {
        TbBicycle bicycle=bicycleService.selectBicycleById(id);
        List<BicycleTypeVo> bicycleTypeVos=bicycleService.bicycleType();
        List<TbPlacement> tbPlacements=bicycleService.placements();
        model.addAttribute("bicycle",bicycle);
        model.addAttribute("bicycleTypeVos",bicycleTypeVos);
        model.addAttribute("tbPlacements",tbPlacements);
        return "page/bicycle/editbicycle";
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResultUtil getBicycleList(Integer page,Integer limit) {
        ResultUtil bicycles = bicycleService.selectBicycles(page, limit);
        return bicycles;
    }

    /**
     * 添加单车信息
     * @param saveVo
     * @return
     */
    @SysLog(value="添加单车信息")
    @RequestMapping("/save")
    @ResponseBody
    public ResultUtil insBicycle(BicycleSaveVo saveVo) {
        try {
            bicycleService.addBicycle(saveVo);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("添加出错,稍后再试！");
        }
    }


    /**
     * 删除指定单车信息
     * @param id
     * @return
     */
    @SysLog(value="删除单车信息")
    @RequestMapping("/delete")
    @ResponseBody
    public ResultUtil delBicycleById(Integer id) {
        try {
            bicycleService.deleteSupplieById(id);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("修改出错,稍后再试！");
        }
    }

    /**
     * 批量删除单车信息
     * @param bicycleStr
     * @return
     */
    @SysLog(value="批量删除单车信息")
    @RequestMapping("/deletes")
    @ResponseBody
    public ResultUtil delBicycle(String bicycleStr) {
        try {
            bicycleService.deleteSuppliesByIds(bicycleStr);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("删除出错,稍后再试！");
        }
    }

    /**
     * 单车信息
     * @param bicycle
     * @return
     */
    @SysLog(value="更新单车信息")
    @RequestMapping("/update")
    @ResponseBody
    public ResultUtil updateBicycle(TbBicycle bicycle) {
        try {

            bicycleService.updateSupplie(bicycle);
            return ResultUtil.ok();
        } catch (Exception e) {
            return ResultUtil.error("删除出错,稍后再试！");
        }
    }

}
