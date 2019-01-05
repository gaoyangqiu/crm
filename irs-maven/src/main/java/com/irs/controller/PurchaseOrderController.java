package com.irs.controller;

import com.irs.annotation.SysLog;
import com.irs.pojo.TbAdmin;
import com.irs.pojo.TbGoods;
import com.irs.pojo.TbPurchaseOrder;
import com.irs.pojo.TbPurchaseReturnOrder;
import com.irs.service.GoodsService;
import com.irs.service.PurchaseOrderService;
import com.irs.service.PurchaseReturnOrderService;
import com.irs.util.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("purchaseOrder/")
public class PurchaseOrderController {

 @Autowired
 private PurchaseOrderService purchaseOrderService;

 @Autowired
 private GoodsService goodsService;

 @Autowired
 private PurchaseReturnOrderService purchaseReturnOrderService;
	@RequestMapping("/purchaseOrderList")
	public String purchaseOrderList() {
		return "page/purchaseOrder/purchaseOrderList";
	}
	

	@RequestMapping("/addPurchaseOrder")
	public String addPurchaseOrder() {
		return "page/purchaseOrder/addpurchaseOrder";
	}
	

	@RequestMapping("/editPurchaseOrder")
	public String editPurchaseOrder(Integer id,Model model) {
		TbPurchaseOrder purchaseOrder=purchaseOrderService.selectPurchaseOrderById(id);
		model.addAttribute("purchaseOrder",purchaseOrder);
		return "page/purchaseOrder/editpurchaseOrder";
	}

	@RequestMapping("/addReturnPurchaseOrder")
	public String addReturnPurchaseOrder(Integer id,Model model) {
		TbPurchaseOrder purchaseOrder=purchaseOrderService.selectPurchaseOrderById(id);
		TbGoods goods=goodsService.selectGoodsById(purchaseOrder.getType());
		model.addAttribute("purchaseOrder",purchaseOrder);
		model.addAttribute("goods",goods);
		return "page/purchaseOrder/addreturnpurchaseOrder";
	}


	/**
	 * 添加采购单
	 * @param
	 * @return
	 */
	@SysLog(value="添加采购单")
	@RequestMapping("/saveReturnPurchaseOrder")
	@ResponseBody
	public ResultUtil saveReturnPurchaseOrder(TbPurchaseReturnOrder purchaseReturnOrder) {
		try {
			//shiro中取出登录的管理员
			TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
			purchaseReturnOrder.setSticks(admin.getId().intValue());
			purchaseReturnOrderService.addPurchaseOrdere(purchaseReturnOrder);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("添加出错,稍后再试！");
		}
	}
	@RequestMapping("/list")
	@ResponseBody
	public ResultUtil getPurchaseOrderList(Integer page,Integer limit) {
		ResultUtil purchaseOrders = purchaseOrderService.selectPurchaseOrders(page, limit);
		return purchaseOrders;
	}
	
	/**
	 * 添加采购单
	 * @param purchaseOrder
	 * @return
	 */
	@SysLog(value="添加采购单")
	@RequestMapping("/save")
	@ResponseBody
	public ResultUtil insPurchaseOrder(TbPurchaseOrder purchaseOrder) {
		try {
			//shiro中取出登录的管理员
			TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
			purchaseOrder.setSticks(admin.getId().intValue());
            purchaseOrderService.addPurchaseOrdere(purchaseOrder);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("添加出错,稍后再试！");
		}
	}

	
	/**
	 * 删除指定采购单
	 * @param id
	 * @return
	 */
	@SysLog(value="删除采购单")
	@RequestMapping("/delete")
	@ResponseBody
	public ResultUtil delPurchaseOrderById(Integer id) {
		try {
            purchaseOrderService.deletePurchaseOrderById(id);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("修改出错,稍后再试！");
		}
	}
	
	/**
	 * 批量删除采购单
	 * @param purchaseOrderStr
	 * @return
	 */
	@SysLog(value="批量删除采购单")
	@RequestMapping("/deletes")
	@ResponseBody
	public ResultUtil delPurchaseOrder(String purchaseOrderStr) {
		try {
            purchaseOrderService.deletePurchaseOrdersByIds(purchaseOrderStr);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("删除出错,稍后再试！");
		}
	}
	
	/**
	 * 采购单
	 * @param purchaseOrder
	 * @return
	 */
	@SysLog(value="更新采购单")
	@RequestMapping("/update")
	@ResponseBody
	public ResultUtil updatePurchaseOrder(TbPurchaseOrder purchaseOrder) {
		try {
			//shiro中取出登录的管理员
			TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
			purchaseOrder.setSticks(admin.getId().intValue());
            purchaseOrderService.updatePurchaseOrder(purchaseOrder);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("删除出错,稍后再试！");
		}
	}
}
