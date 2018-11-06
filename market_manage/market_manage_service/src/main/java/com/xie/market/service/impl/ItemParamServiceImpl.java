package com.xie.market.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xie.common.pojo.Result;
import com.xie.market.mapper.TbItemParamMapper;
import com.xie.market.pojo.TbItemParam;
import com.xie.market.pojo.TbItemParamExample;
import com.xie.market.pojo.TbItemParamExample.Criteria;
import com.xie.market.service.ItemParamService;

/**
 * 商品规格参数
 * @author 谢伟宁
 *
 */
@Service("itemParamService")
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	private TbItemParamMapper itemParamMapper;

	@Override
	public Result getItemParamByCid(Long cid) {

		//example中对单表的查询，创建查询条件
		TbItemParamExample example = new TbItemParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(cid);
		
		List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
		if (list != null && list.size() > 0) {
			return Result.ok(list.get(0));
		}

		return Result.ok();
	}

	@Override
	public Result insertItemParam(TbItemParam itemParam) {
		
		itemParam.setCreated(new Date());
		itemParam.setUpdated(new Date());
		itemParamMapper.insert(itemParam);
		return Result.ok();
	}

}
