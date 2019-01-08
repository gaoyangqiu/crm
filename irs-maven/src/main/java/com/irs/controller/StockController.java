package com.irs.controller;


import com.irs.annotation.SysLog;
import com.irs.pojo.TbStock;
import com.irs.service.StockService;
import com.irs.util.ResultUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("stock/")
public class StockController {
	@Autowired
	private StockService stockService;

	
	@RequestMapping("/stockList")
	public String stockList() {
		return "page/stock/stockList";
	}
	


	@RequestMapping("/list")
	@ResponseBody
	public ResultUtil getStockList(Integer page,Integer limit) {
		ResultUtil stock = stockService.selectStock(page, limit);
		return stock;
	}


	@RequestMapping("/editStock")
	public String editStock(Integer id, Model model) {
		TbStock stock=stockService.selectStockById(id);
		model.addAttribute("stock",stock);
		return "page/stock/editstock";
	}

	/**
	 * 库存
	 * @param stock
	 * @return
	 */
	@SysLog(value="更新库存信息")
	@RequestMapping("/update")
	@ResponseBody
	public ResultUtil updateStock(TbStock stock) {
		try {
			stockService.updateStock(stock);
			return ResultUtil.ok();
		} catch (Exception e) {
			return ResultUtil.error("删除出错,稍后再试！");
		}
	}

}
