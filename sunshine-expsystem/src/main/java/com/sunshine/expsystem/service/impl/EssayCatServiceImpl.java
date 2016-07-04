package com.sunshine.expsystem.service.impl;

import com.sunshine.common.pojo.TreeNode;
import com.sunshine.expsystem.service.EssayCatService;
import com.sunshine.mapper.TbEssayCatMapper;
import com.sunshine.pojo.TbEssayCat;
import com.sunshine.pojo.TbEssayCatExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EssayCatServiceImpl implements EssayCatService {

	@Autowired
	private TbEssayCatMapper tbEssayCatMapper;


	@Override
	public List<TreeNode> getItemCatList(Long parentId){
		TbEssayCatExample catExample = new TbEssayCatExample();
		catExample.createCriteria().andParentIdEqualTo(parentId);
		
		List<TbEssayCat> itemCats = tbEssayCatMapper.selectByExample(catExample);
		List<TreeNode> treeNodes = new ArrayList<>();
		for(TbEssayCat cat : itemCats){
			
			TreeNode treeNode = new TreeNode();
			treeNode.setId(cat.getId());
			treeNode.setText(cat.getName());
			treeNode.setState(cat.getIsParent()?"closed":"open");
			treeNodes.add(treeNode);
		}
		
		return treeNodes;
	}
}
