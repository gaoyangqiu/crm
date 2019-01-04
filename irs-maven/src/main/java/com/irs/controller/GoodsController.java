package com.irs.controller;

import com.irs.annotation.SysLog;
import com.irs.pojo.TbGoods;
import com.irs.service.GoodsService;
import com.irs.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("goods/")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("/goodsList")
	public String goodsList() {
		return "page/goods/goodsList";
	}
	
	@RequiresPermissions("goods:goods:save")
	@RequestMapping("/addGoods")
	public String addGoods() {
		return "page/goods/addgoods";
	}
	
	@RequiresPermissions("goods:goods:save")
	@RequestMapping("/editGoods")
	public String editGoods(Integer id,Model model) {
		TbGoods goods=goodsService.selectGoodsById(id);
		model.addAttribute("goods",goods);
		return "page/goods/editGoods";
	}
	
	@RequestMapping("/list")
	@RequiresPermissions("goods:goods:list")
	@ResponseBody
	public ResultUtil getGoodsList(Integer page,Integer limit) {
		ResultUtil goods = goodsService.selectGoods(page, limit);
		return goods;
	}
	
	/**
	 * 添加商品信息
	 * @param goods
	 * @return
	 */
	@SysLog(value="添加商品信息")
	@RequestMapping("/save")
	@RequiresPermissions("goods:goods:save")
	@ResponseBody
	public ResultUtil insGoods(TbGoods goods) {
		try {
			goodsService.addGoods(goods);
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
	@RequiresPermissions("goods:goods:delete")
	@ResponseBody
	public ResultUtil delGoodsById(Integer id) {
		try {
			goodsService.deleteGoodsById(id);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("修改出错,稍后再试！");
		}
	}
	
	/**
	 * 批量删除轮播图
	 * @param goodsStr
	 * @return
	 */
	@SysLog(value="批量删除商品信息")
	@RequestMapping("/deletes")
	@RequiresPermissions("goods:goods:delete")
	@ResponseBody
	public ResultUtil delGoods(String goodsStr) {
		try {
			goodsService.deleteGoodsByIds(goodsStr);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("删除出错,稍后再试！");
		}
	}
	
	/**
	 * 更新轮播图
	 * @param goods
	 * @return
	 */
	@SysLog(value="更新商品信息")
	@RequestMapping("/update")
	@RequiresPermissions("goods:goods:update")
	@ResponseBody
	public ResultUtil updateGoods(TbGoods goods) {
		try {
			goodsService.updateGoods(goods);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("删除出错,稍后再试！");
		}
	}
}
