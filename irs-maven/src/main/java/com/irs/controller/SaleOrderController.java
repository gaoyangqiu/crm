package com.irs.controller;

import com.irs.annotation.SysLog;
import com.irs.pojo.*;
import com.irs.service.GoodsService;
import com.irs.service.SaleOrderService;
import com.irs.service.SaleReturnOrderService;
import com.irs.util.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("saleOrder/")
public class SaleOrderController {

 @Autowired
 private SaleOrderService saleOrderService;

 @Autowired
 private GoodsService goodsService;

 @Autowired
 private SaleReturnOrderService saleReturnOrderService;
	@RequestMapping("/saleOrderList")
	public String saleOrderList() {
		return "page/saleOrder/saleOrderList";
	}
	

	@RequestMapping("/addSaleOrder")
	public String addSaleOrder() {
		return "page/saleOrder/addsaleOrder";
	}
	

	@RequestMapping("/editSaleOrder")
	public String editSaleOrder(Integer id,Model model) {
		TbSaleOrder saleOrder=saleOrderService.selectSaleOrderById(id);
		model.addAttribute("saleOrder",saleOrder);
		return "page/saleOrder/editsaleOrder";
	}

	@RequestMapping("/addReturnSaleOrder")
	public String addReturnSaleOrder(Integer id,Model model) {
		TbSaleOrder saleOrder=saleOrderService.selectSaleOrderById(id);
		TbGoods goods=goodsService.selectGoodsById(saleOrder.getType());
		model.addAttribute("saleOrder",saleOrder);
		model.addAttribute("goods",goods);
		return "page/saleOrder/addreturnsaleOrder";
	}


	/**
	 * 添加采购单
	 * @param
	 * @return
	 */
	@SysLog(value="添加销售单")
	@RequestMapping("/saveReturnSaleOrder")
	@ResponseBody
	public ResultUtil saveReturnSaleOrder(TbSaleReturnOrder saleReturnOrder) {
		try {
			//shiro中取出登录的管理员
			TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
			saleReturnOrder.setSticks(admin.getId().intValue());
			saleReturnOrderService.addSaleReturnOrder(saleReturnOrder);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("添加出错,稍后再试！");
		}
	}
	@RequestMapping("/list")
	@ResponseBody
	public ResultUtil getSaleOrderList(Integer page,Integer limit) {
		ResultUtil saleOrders = saleOrderService.selectSaleOrders(page, limit);
		return saleOrders;
	}
	
	/**
	 * 添加销售单
	 * @param saleOrder
	 * @return
	 */
	@SysLog(value="添加销售单")
	@RequestMapping("/save")
	@ResponseBody
	public ResultUtil insSaleOrder(TbSaleOrder saleOrder) {
		try {
			//shiro中取出登录的管理员
			TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
			saleOrder.setSticks(admin.getId().intValue());
            saleOrderService.addSaleOrdere(saleOrder);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("添加出错,稍后再试！");
		}
	}

	
	/**
	 * 删除指定销售单
	 * @param id
	 * @return
	 */
	@SysLog(value="删除销售单")
	@RequestMapping("/delete")
	@ResponseBody
	public ResultUtil delSaleOrderById(Integer id) {
		try {
            saleOrderService.deleteSaleOrderById(id);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("修改出错,稍后再试！");
		}
	}
	
	/**
	 * 批量删除销售单
	 * @param saleOrderStr
	 * @return
	 */
	@SysLog(value="批量删除销售单")
	@RequestMapping("/deletes")
	@ResponseBody
	public ResultUtil delSaleOrder(String saleOrderStr) {
		try {
            saleOrderService.deleteSaleOrdersByIds(saleOrderStr);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("删除出错,稍后再试！");
		}
	}
	
	/**
	 * 销售单
	 * @param saleOrder
	 * @return
	 */
	@SysLog(value="更新销售单")
	@RequestMapping("/update")
	@ResponseBody
	public ResultUtil updateSaleOrder(TbSaleOrder saleOrder) {
		try {
			//shiro中取出登录的管理员
			TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
			saleOrder.setSticks(admin.getId().intValue());
            saleOrderService.updateSaleOrder(saleOrder);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("删除出错,稍后再试！");
		}
	}

	@SysLog(value="销售查询统计接口")
	@RequestMapping("/queryStatistics")
	@ResponseBody
	public ResultUtil queryStatistics() {
		ResultUtil saleOrders = saleOrderService.queryStatistics();
		return saleOrders;
	}
}
