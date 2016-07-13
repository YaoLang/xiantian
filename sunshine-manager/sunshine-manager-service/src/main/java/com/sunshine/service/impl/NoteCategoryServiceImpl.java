package com.sunshine.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshine.common.pojo.CommonResult;
import com.sunshine.common.pojo.EUTreeNode;
import com.sunshine.mapper.TbNoteCatMapper;
import com.sunshine.pojo.TbNoteCat;
import com.sunshine.pojo.TbNoteCatExample;
import com.sunshine.service.NoteCategoryService;

@Service
public class NoteCategoryServiceImpl implements NoteCategoryService{
	
	@Autowired
	private TbNoteCatMapper tbNoteCatMapper;

	
	
	@Override
	public CommonResult addNoteCategory(TbNoteCat noteCat) {

		noteCat.setCreated(new Date());
		noteCat.setUpdated(new Date());
		noteCat.setStatus(1);
		noteCat.setIsParent(false);
		noteCat.setSortOrder(1);
		tbNoteCatMapper.insert(noteCat);
		
		TbNoteCat cat = tbNoteCatMapper.selectByPrimaryKey(noteCat.getParentId());
		if(cat.getIsParent()==false){
			cat.setIsParent(true);
			tbNoteCatMapper.updateByPrimaryKey(cat);
		}
		return CommonResult.ok();
	}

	@Override
	public List<EUTreeNode> findNoteCate(long parentid) {
		List<EUTreeNode> euTreeNodes = new ArrayList<>();
		
		TbNoteCatExample catExample = new TbNoteCatExample();
		catExample.createCriteria().andParentIdEqualTo(parentid);
		List<TbNoteCat> noteCats = tbNoteCatMapper.selectByExample(catExample);
		for(TbNoteCat cat : noteCats){
			EUTreeNode node = new EUTreeNode();
			node.setId(cat.getId());
			node.setText(cat.getName());
			node.setState(cat.getIsParent()?"closed":"open");
			euTreeNodes.add(node);
		}
		
		return euTreeNodes;
	}

	@Override
	public CommonResult deleteCategory(long parentid, long notecategoryid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonResult updateCategory(long notecategoryid, String name) {
		TbNoteCat cat = new TbNoteCat();
		cat.setId(notecategoryid);
		cat.setUpdated(new Date());
		cat.setName(name);
		tbNoteCatMapper.updateByPrimaryKeySelective(cat);
		
		return CommonResult.ok();
	}

}
