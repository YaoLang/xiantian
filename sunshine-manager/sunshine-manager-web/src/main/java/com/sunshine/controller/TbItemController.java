package com.sunshine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshine.common.pojo.EUDataGridResult;
import com.sunshine.common.pojo.CommonResult;
import com.sunshine.pojo.TbItem;
import com.sunshine.service.ItemService;

@Controller
public class TbItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value="/item/{itemid}",method=RequestMethod.GET)
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemid){
		return itemService.getItemById(itemid);
	}
	
	@RequestMapping(value="/item/list",method=RequestMethod.GET)
	@ResponseBody
	public EUDataGridResult getItemList(Integer page,Integer rows){
		return itemService.getItemList(page, rows);
	}
	
	@RequestMapping(value="/item/save", method=RequestMethod.POST)
	@ResponseBody 
	private CommonResult createItem(TbItem item,@RequestParam(value="editorValue") String desc,
			@RequestParam(required=false) String itemParams) throws Exception {
		System.out.println(desc);
		CommonResult result = itemService.createItem(item, desc, itemParams);
		return result;
	}
}
