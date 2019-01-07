package com.irs.controller;

import com.irs.annotation.SysLog;
import com.irs.pojo.TbAdmin;
import com.irs.pojo.TbGoods;
import com.irs.pojo.TbPurchaseReturnOrder;
import com.irs.pojo.TbPurchaseReturnOrder;
import com.irs.service.GoodsService;
import com.irs.service.PurchaseReturnOrderService;
import com.irs.service.PurchaseReturnOrderService;
import com.irs.util.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("purchaseReturnOrder/")
public class PurchaseReturnOrderController {

 @Autowired
 private PurchaseReturnOrderService purchaserOrderService;

 @Autowired
 private GoodsService goodsService;

 @Autowired
 private PurchaseReturnOrderService purchaseReturnOrderService;
	@RequestMapping("/purchaseReturnOrderList")
	public String purchaseReturnOrderList() {
		return "page/purchaseReturnOrder/purchaseReturnOrderList";
	}
	

	@RequestMapping("/addPurchaseReturnOrder")
	public String addPurchaseReturnOrder() {
		return "page/purchaseReturnOrder/addpurchaseReturnOrder";
	}
	

	@RequestMapping("/editPurchaseReturnOrder")
	public String editPurchaseReturnOrder(Integer id,Model model) {
		TbPurchaseReturnOrder purchaseReturnOrder=purchaseReturnOrderService.selectPurchaseReturnOrderById(id);
		model.addAttribute("purchaseReturnOrder",purchaseReturnOrder);
		return "page/purchaseReturnOrder/editpurchaseReturnOrder";
	}

	@RequestMapping("/addReturnPurchaseReturnOrder")
	public String addReturnPurchaseReturnOrder(Integer id,Model model) {
		TbPurchaseReturnOrder purchaseReturnOrder=purchaseReturnOrderService.selectPurchaseReturnOrderById(id);
		TbGoods goods=goodsService.selectGoodsById(purchaseReturnOrder.getType());
		model.addAttribute("purchaseReturnOrder",purchaseReturnOrder);
		model.addAttribute("goods",goods);
		return "page/purchaseReturnOrder/addreturnpurchaseReturnOrder";
	}


	@RequestMapping("/list")
	@ResponseBody
	public ResultUtil getPurchaseReturnOrderList(Integer page,Integer limit) {
		ResultUtil purchaseReturnOrders = purchaseReturnOrderService.selectPurchaseReturnOrders(page, limit);
		return purchaseReturnOrders;
	}
	
	/**
	 * 添加采购退货单
	 * @param purchaseReturnOrder
	 * @return
	 */
	@SysLog(value="添加采购单")
	@RequestMapping("/save")
	@ResponseBody
	public ResultUtil insPurchaseReturnOrder(TbPurchaseReturnOrder purchaseReturnOrder) {
		try {
			//shiro中取出登录的管理员
			TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
			purchaseReturnOrder.setSticks(admin.getId().intValue());
            purchaseReturnOrderService.addPurchaseReturnOrder(purchaseReturnOrder);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("添加出错,稍后再试！");
		}
	}

	
	/**
	 * 删除指定采购退货单
	 * @param id
	 * @return
	 */
	@SysLog(value="删除采购单")
	@RequestMapping("/delete")
	@ResponseBody
	public ResultUtil delPurchaseReturnOrderById(Integer id) {
		try {
            purchaseReturnOrderService.deletePurchaseReturnOrderById(id);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("修改出错,稍后再试！");
		}
	}
	
	/**
	 * 批量删除采购退货单
	 * @param purchaseReturnOrderStr
	 * @return
	 */
	@SysLog(value="批量删除采购退货单")
	@RequestMapping("/deletes")
	@ResponseBody
	public ResultUtil delPurchaseReturnOrder(String purchaseReturnOrderStr) {
		try {
            purchaseReturnOrderService.deletePurchaseReturnOrdersByIds(purchaseReturnOrderStr);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("删除出错,稍后再试！");
		}
	}
	
	/**
	 * 采购单
	 * @param purchaseReturnOrder
	 * @return
	 */
	@SysLog(value="更新采购退货单")
	@RequestMapping("/update")
	@ResponseBody
	public ResultUtil updatePurchaseReturnOrder(TbPurchaseReturnOrder purchaseReturnOrder) {
		try {
			//shiro中取出登录的管理员
			TbAdmin admin = (TbAdmin) SecurityUtils.getSubject().getPrincipal();
			purchaseReturnOrder.setSticks(admin.getId().intValue());
            purchaseReturnOrderService.updatePurchaseReturnOrder(purchaseReturnOrder);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("删除出错,稍后再试！");
		}
	}
}
