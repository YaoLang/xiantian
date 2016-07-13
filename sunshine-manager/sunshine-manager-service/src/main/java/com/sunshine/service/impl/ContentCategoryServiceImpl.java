package com.sunshine.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshine.common.pojo.EUTreeNode;
import com.sunshine.common.pojo.CommonResult;
import com.sunshine.mapper.TbContentCategoryMapper;
import com.sunshine.pojo.TbContentCategory;
import com.sunshine.pojo.TbContentCategoryExample;
import com.sunshine.service.ContentCategoryService;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService{

	@Autowired
	private TbContentCategoryMapper tbContentCategoryMapper;
	
	
	@Override
	public List<EUTreeNode> getContentCategoryList(long parentId) {
		List<EUTreeNode> treeNodes = new ArrayList<>();
		
		TbContentCategoryExample example = new TbContentCategoryExample();
		example.createCriteria().andParentIdEqualTo(parentId);
		List<TbContentCategory> categories = tbContentCategoryMapper.selectByExample(example);
		for(TbContentCategory category : categories){
			EUTreeNode node = new EUTreeNode();
			node.setId(category.getId());
			node.setText(category.getName());
			node.setState(category.getIsParent()?"closed":"open");
			treeNodes.add(node);
		}
		
		return treeNodes;
	}


	@Override
	public CommonResult insertContentCategory(TbContentCategory contentCategory) {
		Date date = new Date();
		contentCategory.setCreated(date);
		contentCategory.setUpdated(date);
		contentCategory.setIsParent(false);
		contentCategory.setSortOrder(1);
		contentCategory.setStatus(1);
		tbContentCategoryMapper.insert(contentCategory);
		
		TbContentCategory category = tbContentCategoryMapper.selectByPrimaryKey(contentCategory.getParentId());
		if(!category.getIsParent()){
			category.setIsParent(true);
			tbContentCategoryMapper.updateByPrimaryKey(category);
		}
		return CommonResult.ok(contentCategory);
	}


	@Override
	public CommonResult deleteContentCategory(long parent_id, long id) {
		TbContentCategory category = new TbContentCategory();
		category.setId(id);
		category.setUpdated(new Date());
		category.setStatus(2);
		tbContentCategoryMapper.updateByPrimaryKeySelective(category);
		
		TbContentCategoryExample example = new TbContentCategoryExample();
		example.createCriteria().andParentIdEqualTo(parent_id).andStatusEqualTo(1);
		int count = tbContentCategoryMapper.countByExample(example);
		if(count==0){
			TbContentCategory parent = new TbContentCategory();
			parent.setId(parent_id);
			parent.setIsParent(false);
			tbContentCategoryMapper.updateByPrimaryKeySelective(parent);
		}
		return CommonResult.ok();
	}


	@Override
	public CommonResult updateContentCategory(long id, String name) {
		TbContentCategory category = new TbContentCategory();
		category.setId(id);
		category.setName(name);
		category.setUpdated(new Date());
		tbContentCategoryMapper.updateByPrimaryKeySelective(category);
		return CommonResult.ok();
	}

	
}
