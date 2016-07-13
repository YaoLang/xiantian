package com.sunshine.service;

import com.sunshine.common.pojo.CommonResult;
import com.sunshine.pojo.TbItemParam;

public interface ItemParamService {

	public CommonResult insertItemParam(TbItemParam itemParam);
	
	public CommonResult getItemParamByCid(long cid);
	
}
