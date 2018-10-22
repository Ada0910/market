package com.xie.market.service;

import java.util.List;

import com.xie.common.pojo.EUTreeNode;

/**
 * 商品类目选择的接口
 * 
 * @author 谢伟宁
 *
 */
public interface ItemCatService {

	List<EUTreeNode> getCatList(long parentId);

}
