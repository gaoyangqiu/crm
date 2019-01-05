package com.irs.controller;

import com.irs.annotation.SysLog;
import com.irs.pojo.TbSupplier;
import com.irs.service.SupplierService;
import com.irs.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("supplier/")
public class supplierController {

 @Autowired
 private SupplierService supplierService;
	
	@RequestMapping("/supplierList")
	public String supplierList() {
		return "page/supplier/supplierList";
	}
	
/*	@RequiresPermissions("supplier:supplier:save")*/
	@RequestMapping("/addSupplier")
	public String addCustomer() {
		return "page/supplier/addsupplier";
	}
	
/*	@RequiresPermissions("supplier:supplier:save")*/
	@RequestMapping("/editSupplier")
	public String editCustomer(Integer id,Model model) {
		TbSupplier supplier=supplierService.selectSupplieById(id);
		model.addAttribute("supplier",supplier);
		return "page/supplier/editsupplier";
	}
	
	@RequestMapping("/list")
/*	@RequiresPermissions("supplier:supplier:list")*/
	@ResponseBody
	public ResultUtil getSupplierList(Integer page,Integer limit) {
		ResultUtil suppliers = supplierService.selectSupplies(page, limit);
		return suppliers;
	}
	
	/**
	 * 添加供应商信息
	 * @param supplier
	 * @return
	 */
	@SysLog(value="添加供应商信息")
	@RequestMapping("/save")
/*	@RequiresPermissions("supplier:supplier:save")*/
	@ResponseBody
	public ResultUtil insCustomer(TbSupplier supplier) {
		try {
            supplierService.addSupplie(supplier);
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
/*	@RequiresPermissions("supplier:supplier:delete")*/
	@ResponseBody
	public ResultUtil delCustomerById(Integer id) {
		try {
            supplierService.deleteSupplieById(id);
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
/*	@RequiresPermissions("supplier:supplier:delete")*/
	@ResponseBody
	public ResultUtil delCustomer(String supplierStr) {
		try {
            supplierService.deleteSuppliesByIds(supplierStr);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("删除出错,稍后再试！");
		}
	}
	
	/**
	 * 供应商信息
	 * @param supplier
	 * @return
	 */
	@SysLog(value="更新供应商信息")
	@RequestMapping("/update")
/*	@RequiresPermissions("supplier:supplier:update")*/
	@ResponseBody
	public ResultUtil updateCustomer(TbSupplier supplier) {
		try {
            supplierService.updateSupplie(supplier);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("删除出错,稍后再试！");
		}
	}
}
