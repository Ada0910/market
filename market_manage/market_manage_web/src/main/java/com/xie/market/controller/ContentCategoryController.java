package com.xie.market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xie.common.pojo.EUTreeNode;
import com.xie.common.pojo.Result;
import com.xie.market.service.ContentCategoryService;

/**
 * 内容分类管理
 * 
 * @author 谢伟宁
 *
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

	@Autowired
	@Qualifier("contentCategoryService")
	private ContentCategoryService contentCategoryService;

	@RequestMapping("/list")
	@ResponseBody
	public List<EUTreeNode> getContentCatList(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
		List<EUTreeNode> list = contentCategoryService.getCategoryList(parentId);
		return list;
	}

	@RequestMapping("/create")
	@ResponseBody
	public Result createContentCategory(Long parentId, String name) {
		Result result = contentCategoryService.insertContentCategory(parentId, name);
		return result;
	}

}
