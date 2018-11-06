package com.xie.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xie.common.pojo.Result;
import com.xie.market.pojo.TbItemParam;
import com.xie.market.service.ItemParamService;

@Controller
@RequestMapping("/item/param")
public class ItemParamController {

	@Autowired
	@Qualifier("itemParamService")
	private ItemParamService itemParamService;

	@RequestMapping("/query/itemcatid/{itemCatId}")
	@ResponseBody
	public Result getItemParamByCid(@PathVariable Long itemCatId) {
		Result result = itemParamService.getItemParamByCid(itemCatId);
		return result;

	}
	
	@RequestMapping("/save/{cid}")
	@ResponseBody
	public Result insertItemParam(@PathVariable Long cid,String paramData){
		
		TbItemParam itemParam = new TbItemParam();
		itemParam.setItemCatId(cid);
		itemParam.setParamData(paramData);
		Result result = itemParamService.insertItemParam(itemParam);
		return result;
	}

}
