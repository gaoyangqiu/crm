package com.irs.controller;

import com.irs.annotation.SysLog;
import com.irs.pojo.TbAdmin;
import com.irs.pojo.TbGoods;
import com.irs.pojo.TbSaleReturnOrder;
import com.irs.service.GoodsService;
import com.irs.service.SaleReturnOrderService;
import com.irs.util.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("saleReturnOrder/")
public class SaleReturnOrderController {

 @Autowired
 private SaleReturnOrderService purchaserOrderService;

 @Autowired
 private GoodsService goodsService;

 @Autowired
 private SaleReturnOrderService saleReturnOrderService;
	@RequestMapping("/saleReturnOrderList")
	public String saleReturnOrderList() {
		return "page/saleReturnOrder/saleReturnOrderList";
	}
	

/*	@RequestMapping("/addSaleReturnOrder")
	public String addSaleReturnOrder() {
		return "page/saleReturnOrder/addsaleReturnOrder";
	}
	*/

	@RequestMapping("/editSaleReturnOrder")
	public String editSaleReturnOrder(Integer id,Model model) {
		TbSaleReturnOrder saleReturnOrder=saleReturnOrderService.selectSaleReturnOrderById(id);
		model.addAttribute("saleReturnOrder",saleReturnOrder);
		return "page/saleReturnOrder/editsaleReturnOrder";
	}

/*
	@RequestMapping("/addReturnSaleReturnOrder")
	public String addReturnSaleReturnOrder(Integer id,Model model) {
		TbSaleReturnOrder saleReturnOrder=saleReturnOrderService.selectSaleReturnOrderById(id);
		TbGoods goods=goodsService.selectGoodsById(saleReturnOrder.getType());
		model.addAttribute("saleReturnOrder",saleReturnOrder);
		model.addAttribute("goods",goods);
		return "page/saleReturnOrder/addreturnsaleReturnOrder";
	}
*/


	@RequestMapping("/list")
	@ResponseBody
	public ResultUtil getSaleReturnOrderList(Integer page,Integer limit) {
		ResultUtil saleReturnOrders = saleReturnOrderService.selectSaleReturnOrders(page, limit);
		return saleReturnOrders;
	}
	
	/**
	 * 添加销售退货单
	 * @param saleReturnOrder
	 * @return
	 */
/*	@SysLog(value="添加销售单")
	@RequestMapping("/save")
	@ResponseBody
	public ResultUtil insSaleReturnOrder(TbSaleReturnOrder saleReturnOrder) {
		try {
			//shiro中取出登录的管理员
			TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
			saleReturnOrder.setSticks(admin.getId().intValue());
            saleReturnOrderService.addSaleReturnOrder(saleReturnOrder);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("添加出错,稍后再试！");
		}
	}*/

	
	/**
	 * 删除指定销售退货单
	 * @param id
	 * @return
	 */
	@SysLog(value="删除销售单")
	@RequestMapping("/delete")
	@ResponseBody
	public ResultUtil delSaleReturnOrderById(Integer id) {
		try {
            saleReturnOrderService.deleteSaleReturnOrderById(id);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("修改出错,稍后再试！");
		}
	}
	
	/**
	 * 批量删除销售退货单
	 * @param saleReturnOrderStr
	 * @return
	 */
	@SysLog(value="批量删除销售退货单")
	@RequestMapping("/deletes")
	@ResponseBody
	public ResultUtil delSaleReturnOrder(String saleReturnOrderStr) {
		try {
            saleReturnOrderService.deleteSaleReturnOrdersByIds(saleReturnOrderStr);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("删除出错,稍后再试！");
		}
	}
	
	/**
	 * 销售单
	 * @param saleReturnOrder
	 * @return
	 */
	@SysLog(value="更新销售退货单")
	@RequestMapping("/update")
	@ResponseBody
	public ResultUtil updateSaleReturnOrder(TbSaleReturnOrder saleReturnOrder) {
		try {
			//shiro中取出登录的管理员
			TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
			saleReturnOrder.setSticks(admin.getId().intValue());
            saleReturnOrderService.updateSaleReturnOrder(saleReturnOrder);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("删除出错,稍后再试！");
		}
	}
}
