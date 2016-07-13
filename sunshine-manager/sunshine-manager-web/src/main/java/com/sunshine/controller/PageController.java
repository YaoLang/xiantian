package com.sunshine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunshine.common.pojo.CommonResult;
import com.sunshine.common.pojo.TreeNode;
import com.sunshine.service.ItemCatService;
import com.sunshine.service.ItemService;

@Controller
public class PageController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}

	@RequestMapping("/item")
	public String item(Model model){
		CommonResult result = itemService.getAllItem();
		if(result.getStatus()==200){
			model.addAttribute("items", result.getData());
		}
		return "item";
	}
	
	@RequestMapping("/additem")
	public String additem(Model model){
		List<TreeNode> nodes = itemCatService.getItemCatList(Long.valueOf(0L));
		model.addAttribute("parent", nodes);
		return "additem";
	}
	
	@RequestMapping("/200")
	public String success(){
		return "200";
	}

}
