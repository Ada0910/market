package com.xie.market.service;

import com.xie.common.pojo.EUDataGridResult;
import com.xie.common.pojo.Result;
import com.xie.market.pojo.TbItem;

public interface ItemService {

	/**
	 * 分页查询商品的列表
	 * 
	 * 时间 2018年10月10日 下午5:14:20
	 * 谢伟宁
	 * @param page 要显示第几页
	 * @param rows  每页显示的条数
	 * @return
	 */
	EUDataGridResult getItemList(int page, int rows);
	TbItem getItemById(long itemId);
	Result createItem(TbItem item,String desc,String itemParam)throws Exception;
}
