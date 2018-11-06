package com.xie.market.service;

import java.util.List;

import com.xie.common.pojo.EUTreeNode;
import com.xie.common.pojo.Result;

public interface ContentCategoryService {
	
	List<EUTreeNode> getCategoryList(long parentId);
	Result insertContentCategory(Long parentId ,String name);

}
