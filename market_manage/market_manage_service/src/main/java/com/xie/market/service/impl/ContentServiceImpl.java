package com.xie.market.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xie.common.pojo.Result;
import com.xie.market.mapper.TbContentMapper;
import com.xie.market.mapper.TbItemCatMapper;
import com.xie.market.pojo.TbContent;
import com.xie.market.service.ContentService;

/**
 * 内容管理
 * 
 * @author 谢伟宁
 *
 */
@Service("contentService")
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;

	@Override
	public Result insertContent(TbContent content) {

		content.setCreated(new Date());
		content.setUpdated(new Date());
		contentMapper.insert(content);
		return Result.ok();
	}

}
