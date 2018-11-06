package com.xie.market.service;

import com.xie.common.pojo.Result;
import com.xie.market.pojo.TbItemParam;

public interface ItemParamService {
	
	Result getItemParamByCid(Long cid);
	Result insertItemParam(TbItemParam itemParam);
	

}
