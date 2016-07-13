package com.sunshine.service;

import java.util.List;

import com.sunshine.common.pojo.EUTreeNode;
import com.sunshine.common.pojo.CommonResult;
import com.sunshine.pojo.TbContentCategory;

public interface ContentCategoryService {

	public List<EUTreeNode> getContentCategoryList(long parentId);
	
	public CommonResult insertContentCategory(TbContentCategory contentCategory);
	
	public CommonResult deleteContentCategory(long parent_id,long id);
	
	public CommonResult updateContentCategory(long id,String name);
	
	
}
