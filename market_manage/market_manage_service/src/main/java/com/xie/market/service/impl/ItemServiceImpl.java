package com.xie.market.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xie.common.pojo.EUDataGridResult;
import com.xie.common.pojo.Result;
import com.xie.common.utils.IDUtils;
import com.xie.market.mapper.TbItemMapper;
import com.xie.market.pojo.TbItemExample.Criteria;
import com.xie.market.pojo.TbItem;
import com.xie.market.pojo.TbItemExample;
import com.xie.market.service.ItemService;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;

	/**
	 * 商品列表查询的实现方法
	 */
	@Override
	public EUDataGridResult getItemList(int page, int rows) {

		// 查询商品列表
		TbItemExample example = new TbItemExample();
		// 分页处理
		PageHelper.startPage(page, rows);
		// 返回一个list对象列表
		List<TbItem> list = itemMapper.selectByExample(example);
		// 创建一个EUDataGridResult
		EUDataGridResult result = new EUDataGridResult();
		// 传入list的参数
		result.setRows(list);
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		result.setTotal(pageInfo.getTotal());
		return result;

	}

	@Override
	public TbItem getItemById(long itemId) {
		//添加查询条件
				TbItemExample example = new TbItemExample();
				Criteria criteria = example.createCriteria();
				criteria.andIdEqualTo(itemId);
				List<TbItem> list = itemMapper.selectByExample(example);
				if (list != null && list.size() > 0) {
					TbItem item = list.get(0);
					return item;
				}
				return null;
	}

	
	/**
	 * 插入新增商品的数据
	 */
	@Override
	public Result createItem(TbItem item, String desc, String itemParam) throws Exception {
		
		Long itemIdLong = IDUtils.getItemId();
		item.setId(itemIdLong);
		item.setStatus((byte) 1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		itemMapper.insert(item);
		
		return Result.ok();
	}

}
