package com.xie.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xie.common.pojo.EUDataGridResult;
import com.xie.common.pojo.Result;
import com.xie.market.pojo.TbItem;
import com.xie.market.service.ItemService;

@Controller
public class ItemControlller {

	@Autowired
	@Qualifier("itemService")
	private ItemService itemService;

	/**
	 * 商品列表查询的controller层s 时间 2018年10月10日 下午5:29:24 谢伟宁
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */

	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {

		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}

	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows) {

		EUDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}

	@RequestMapping("/item/save")
	@ResponseBody
	private Result createItem(TbItem item, String desc, String itemParam) throws Exception {

		Result result = itemService.createItem(item, desc, itemParam);
		return result;
	}

}
