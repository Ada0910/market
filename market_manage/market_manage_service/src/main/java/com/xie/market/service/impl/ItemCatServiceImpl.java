package com.xie.market.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xie.common.pojo.EUTreeNode;
import com.xie.market.mapper.TbItemCatMapper;
import com.xie.market.pojo.TbItemCat;
import com.xie.market.pojo.TbItemCatExample;
import com.xie.market.pojo.TbItemCatExample.Criteria;
import com.xie.market.service.ItemCatService;

/**
 * 商品类目选择的逻辑实现
 * 
 * @author 谢伟宁
 *
 */
@Service("itemCatService")
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Override
	public List<EUTreeNode> getCatList(long parentId) {

		// example类是针对单表进行操作（脱离sql语句的）的类
		// 创建查询条件
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);

		// 根据条件查询
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		List<EUTreeNode> resultList = new ArrayList<>();

		// 把列表转换成treeNodeList
		for (TbItemCat tbItemCat : list) {
			EUTreeNode node = new EUTreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent()?"closed":"open");
            resultList.add(node);
		}

		return resultList;
	}

}
