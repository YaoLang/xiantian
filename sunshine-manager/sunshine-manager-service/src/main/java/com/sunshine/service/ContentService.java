package com.sunshine.service;

import com.sunshine.common.pojo.EUDataGridResult;
import com.sunshine.common.pojo.CommonResult;
import com.sunshine.pojo.TbContent;

public interface ContentService {

	public EUDataGridResult getContentList(long category_id,Integer page,Integer rows);
	
	public CommonResult addContent(TbContent content);
	
	public CommonResult updateContent(TbContent content);
}
