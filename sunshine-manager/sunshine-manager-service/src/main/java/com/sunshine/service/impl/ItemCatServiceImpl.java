package com.sunshine.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshine.common.pojo.TreeNode;
import com.sunshine.mapper.TbItemCatMapper;
import com.sunshine.pojo.TbItemCat;
import com.sunshine.pojo.TbItemCatExample;
import com.sunshine.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService{

	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Override
	public List<TreeNode> getItemCatList(Long parentId){
		TbItemCatExample catExample = new TbItemCatExample();
		catExample.createCriteria().andParentIdEqualTo(parentId);
		
		List<TbItemCat> itemCats = itemCatMapper.selectByExample(catExample);
		List<TreeNode> treeNodes = new ArrayList<>();
		for(TbItemCat cat : itemCats){
			
			TreeNode treeNode = new TreeNode();
			treeNode.setId(cat.getId());
			treeNode.setText(cat.getName());
			treeNode.setState(cat.getIsParent()?"closed":"open");
			treeNodes.add(treeNode);
		}
		
		return treeNodes;
	}
}
