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
import com.xie.market.mapper.TbItemDescMapper;
import com.xie.market.mapper.TbItemMapper;
import com.xie.market.mapper.TbItemParamItemMapper;
import com.xie.market.pojo.TbItemExample.Criteria;
import com.xie.market.pojo.TbItemParamItem;
import com.xie.market.pojo.TbItem;
import com.xie.market.pojo.TbItemDesc;
import com.xie.market.pojo.TbItemExample;
import com.xie.market.service.ItemService;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;

	@Autowired
	private TbItemDescMapper itemDescMapper;
	
	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;

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
		// 添加查询条件
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

		Long itemId = IDUtils.getItemId();
		item.setId(itemId);
		item.setStatus((byte) 0);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		itemMapper.insert(item);

		// 添加商品描述
		Result result = insertItemDesc(itemId, desc);
		if (result.getStatus() != 200) {
			throw new Exception();
		}
		result = insertItemParamItem(itemId, itemParam);
		if(result.getStatus()!=200){
			throw new Exception();
		}

		return Result.ok();
	}

	/**
	 * 添加商品描述
	 */
	private Result insertItemDesc(Long itemId, String desc) {

		TbItemDesc itemDesc = new TbItemDesc();
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(new Date());
		itemDescMapper.insert(itemDesc);
		return Result.ok();
	}
	
	/**
	 * 添加规格参数
	 * 
	 * 时间 2018年10月25日 下午5:33:30
	 * 谢伟宁
	 * @param itemId
	 * @param itemParam
	 * @return
	 */
	
	private Result insertItemParamItem(Long itemId,String itemParam){
	
		TbItemParamItem itemParamItem  = new TbItemParamItem();
		itemParamItem.setItemId(itemId);
		itemParamItem.setParamData(itemParam);
        itemParamItem.setCreated(new Date());
        itemParamItem.setUpdated(new Date());
        itemParamItemMapper.insert(itemParamItem);
		return Result.ok();
	}

}
