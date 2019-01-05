package com.irs.controller;

import com.irs.annotation.SysLog;
import com.irs.pojo.TbCustomer;
import com.irs.service.CustomerService;
import com.irs.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("customer/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
	
	@RequestMapping("/customerList")
	public String goodsList() {
		return "page/customer/customerList";
	}
	
	@RequiresPermissions("customer:customer:save")
	@RequestMapping("/addCustomer")
	public String addCustomer() {
		return "page/customer/addcustomer";
	}
	
	@RequiresPermissions("customer:customer:save")
	@RequestMapping("/editCustomer")
	public String editCustomer(Integer id,Model model) {
		TbCustomer customer=customerService.selectCustomerById(id);
		model.addAttribute("customer",customer);
		return "page/customer/editcustomer";
	}
	
	@RequestMapping("/list")
	@RequiresPermissions("customer:customer:list")
	@ResponseBody
	public ResultUtil getCustomerList(Integer page,Integer limit) {
		ResultUtil customers = customerService.selectCustomers(page, limit);
		return customers;
	}
	
	/**
	 * 添加商品信息
	 * @param customer
	 * @return
	 */
	@SysLog(value="添加商品信息")
	@RequestMapping("/save")
	@RequiresPermissions("customer:customer:save")
	@ResponseBody
	public ResultUtil insCustomer(TbCustomer customer) {
		try {
            customerService.addCustomers(customer);
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
	@RequiresPermissions("customer:customer:delete")
	@ResponseBody
	public ResultUtil delCustomerById(Integer id) {
		try {
            customerService.deleteCustomerById(id);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("修改出错,稍后再试！");
		}
	}
	
	/**
	 * 批量删除轮播图
	 * @param customerStr
	 * @return
	 */
	@SysLog(value="批量删除商品信息")
	@RequestMapping("/deletes")
	@RequiresPermissions("customer:customer:delete")
	@ResponseBody
	public ResultUtil delCustomer(String customerStr) {
		try {
            customerService.deleteCustomersByIds(customerStr);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("删除出错,稍后再试！");
		}
	}
	
	/**
	 * 更新轮播图
	 * @param customer
	 * @return
	 */
	@SysLog(value="更新商品信息")
	@RequestMapping("/update")
	@RequiresPermissions("customer:customer:update")
	@ResponseBody
	public ResultUtil updateCustomer(TbCustomer customer) {
		try {
            customerService.updateCustomer(customer);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("删除出错,稍后再试！");
		}
	}
}
