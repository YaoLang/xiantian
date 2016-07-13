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
import com.sunshine.pojo.TbNoteCat;
import com.sunshine.service.NoteCategoryService;

@RequestMapping("/notecat")
@Controller
public class NoteCategoryController {
 
	@Autowired
	private NoteCategoryService noteCategoryService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EUTreeNode> getContentCatList(@RequestParam(value="id",defaultValue="0")long parentId){
		return noteCategoryService.findNoteCate(parentId);
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public CommonResult addNode(Long parentId,String name){
		TbNoteCat tbNoteCat = new TbNoteCat();
		tbNoteCat.setParentId(parentId);
		tbNoteCat.setName(name);
		return noteCategoryService.addNoteCategory(tbNoteCat);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public CommonResult deleteNode(Long parentId,Long id){
		return CommonResult.ok();
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public CommonResult updateNode(Long id,String name){
		return noteCategoryService.updateCategory(id, name);
	}
}
