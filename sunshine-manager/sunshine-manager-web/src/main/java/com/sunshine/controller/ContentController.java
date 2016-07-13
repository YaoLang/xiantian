package com.sunshine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshine.common.pojo.CommonResult;
import com.sunshine.common.pojo.EUDataGridResult;
import com.sunshine.pojo.TbContent;
import com.sunshine.service.ContentService;

@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/query/list")
	@ResponseBody
	public EUDataGridResult getContentList(Long categoryId, Integer page, Integer rows) throws Exception {
		EUDataGridResult result = contentService.getContentList(categoryId, page, rows);
		return result;
		
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public CommonResult addContent(TbContent content){
		return contentService.addContent(content);
	}

	@RequestMapping("/edit")
	@ResponseBody
	public CommonResult editContent(TbContent content){
		return contentService.updateContent(content);
	}
}
