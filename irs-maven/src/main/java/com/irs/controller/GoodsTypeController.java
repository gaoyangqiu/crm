package com.irs.controller;

import com.irs.annotation.SysLog;
import com.irs.pojo.TbGoodsType;
import com.irs.service.GoodsTypeService;
import com.irs.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("goodsType/")
public class GoodsTypeController {
	@Autowired
	private GoodsTypeService goodsTypeService;
	
	@RequestMapping("/goodsTypeList")
	public String goodsTypeList() {
		return "page/goodstype/goodstypeList";
	}
	

	@RequestMapping("/addGoodsType")
	public String addGoodsType() {
		return "page/goodstype/addgoodstype";
	}
	

	@RequestMapping("/editGoodsType")
	public String editGoodsType(Integer id,Model model) {
		TbGoodsType goodsType=goodsTypeService.selectGoodsTypeById(id);
		model.addAttribute("goodsType",goodsType);
		return "page/goodstype/editgoodstype";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public ResultUtil getGoodsTypeList(Integer page,Integer limit) {
		ResultUtil goodsType = goodsTypeService.selectGoodsType(page, limit);
		return goodsType;
	}
	
	/**
	 * 添加商品信息
	 * @param goodsType
	 * @return
	 */
	@SysLog(value="添加商品信息")
	@RequestMapping("/save")
	@ResponseBody
	public ResultUtil insGoodsType(TbGoodsType goodsType) {
		try {
			goodsTypeService.addGoodsType(goodsType);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("添加出错,稍后再试！");
		}
	}

	
	/**
	 * 删除指定商品信息
	 * @param id
	 * @return
	 */
	@SysLog(value="删除商品信息")
	@RequestMapping("/delete")
	@ResponseBody
	public ResultUtil delGoodsTypeById(Integer id) {
		try {
			goodsTypeService.deleteGoodsTypeByid(id);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("修改出错,稍后再试！");
		}
	}
	

	@SysLog(value="批量删除商品信息")
	@RequestMapping("/deletes")
	@ResponseBody
	public ResultUtil delGoodsType(String goodsTypeStr) {
		try {
			goodsTypeService.deleteStocskByIds(goodsTypeStr);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("删除出错,稍后再试！");
		}
	}
	

	@SysLog(value="更新商品信息")
	@RequestMapping("/update")
	@ResponseBody
	public ResultUtil updateGoodsType(TbGoodsType goodsType) {
		try {
			goodsTypeService.updateGoodsType(goodsType);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("删除出错,稍后再试！");
		}
	}
}
