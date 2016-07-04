package com.sunshine.expsystem.controller;

import com.sunshine.common.pojo.TreeNode;
import com.sunshine.expsystem.service.EssayCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/item/cat")
public class EssayCatController {

	@Autowired
	private EssayCatService itemCatService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<TreeNode> getItemCatList(@RequestParam(value="id",defaultValue="0")Long parentId){
		return itemCatService.getItemCatList(parentId);
	}


}
