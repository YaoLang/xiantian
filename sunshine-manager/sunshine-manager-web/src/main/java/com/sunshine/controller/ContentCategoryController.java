package com.sunshine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshine.common.pojo.CommonResult;
import com.sunshine.common.pojo.EUTreeNode;
import com.sunshine.pojo.TbContentCategory;
import com.sunshine.service.ContentCategoryService;

@RequestMapping("/content/category")
@Controller
public class ContentCategoryController {

	@Autowired
	private ContentCategoryService contentCategoryService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EUTreeNode> getContentCatList(@RequestParam(value="id",defaultValue="0")long parentId){
		return contentCategoryService.getContentCategoryList(parentId);
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public CommonResult addNode(Long parentId,String name){
		TbContentCategory tbContentCategory = new TbContentCategory();
		tbContentCategory.setParentId(parentId);
		tbContentCategory.setName(name);
		return contentCategoryService.insertContentCategory(tbContentCategory);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public CommonResult deleteNode(Long parentId,Long id){
		System.out.println(parentId);
		return contentCategoryService.deleteContentCategory(parentId, id);
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public CommonResult updateNode(Long id,String name){
		return contentCategoryService.updateContentCategory(id, name);
	}
}
