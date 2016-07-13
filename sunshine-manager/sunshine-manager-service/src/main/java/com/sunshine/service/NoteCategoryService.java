package com.sunshine.service;

import java.util.List;

import com.sunshine.common.pojo.CommonResult;
import com.sunshine.common.pojo.EUTreeNode;
import com.sunshine.pojo.TbNoteCat;

public interface NoteCategoryService {

	public CommonResult addNoteCategory(TbNoteCat noteCat);
	
	public List<EUTreeNode> findNoteCate(long parentid);
	
	public CommonResult deleteCategory(long parentid,long notecategoryid);
	
	public CommonResult updateCategory(long notecategoryid,String name);
	
	
}
