package com.sunshine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshine.common.pojo.CommonResult;
import com.sunshine.pojo.TbItemParam;
import com.sunshine.service.ItemParamService;

@Controller
@RequestMapping("/item/param")
public class ItemParamController {

	@Autowired
	private ItemParamService itemParamService;

	
	@RequestMapping("/query/itemcatid/{itemcatid}")
	@ResponseBody
	public CommonResult getItemParamByCid(@PathVariable long cid){
		CommonResult taotaoResult = itemParamService.getItemParamByCid(cid);
			return taotaoResult;
	
	}
	
	
	@RequestMapping("/save/{cid}")
	@ResponseBody
	public CommonResult insertItemParam(@PathVariable long cid,String paramData){
		TbItemParam itemParam = new TbItemParam();
		itemParam.setParamData(paramData);
		CommonResult taotaoResult = itemParamService.insertItemParam(itemParam);
		return taotaoResult;
	}
}
