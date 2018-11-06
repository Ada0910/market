package com.xie.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xie.common.pojo.Result;
import com.xie.market.pojo.TbContent;
import com.xie.market.service.ContentService;

@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	@Qualifier("contentService")
	private ContentService contentService;

	@RequestMapping("/save")
	@ResponseBody
	public Result insertContent(TbContent content) {

		Result result = contentService.insertContent(content);
		return Result.ok();
	}

}
