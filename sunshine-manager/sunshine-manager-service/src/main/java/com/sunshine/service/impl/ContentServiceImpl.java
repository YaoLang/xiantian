package com.sunshine.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunshine.common.pojo.EUDataGridResult;
import com.sunshine.common.pojo.CommonResult;
import com.sunshine.common.utils.HttpClientUtil;
import com.sunshine.mapper.TbContentMapper;
import com.sunshine.pojo.TbContent;
import com.sunshine.pojo.TbContentExample;
import com.sunshine.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService{

	@Autowired
	private TbContentMapper tbContentMapper;
	
	@Value("${CMS_CACHE_SYNC}")
	private String CMS_CACHE_SYNC;
	
	@Override
	public EUDataGridResult getContentList(long category_id, Integer page, Integer rows) {
		TbContentExample example = new TbContentExample();
		example.createCriteria().andCategoryIdEqualTo(category_id);
		
		PageHelper.startPage(page, rows);
		List<TbContent> contents = tbContentMapper.selectByExample(example);
		
		PageInfo<TbContent> pageInfo = new PageInfo<>(contents);
		
		EUDataGridResult gridResult = new EUDataGridResult();
		gridResult.setTotal(pageInfo.getTotal());
		gridResult.setRows(contents);
		return gridResult;
	}

	@Override
	public CommonResult addContent(TbContent content) {
		content.setCreated(new Date());
		content.setUpdated(new Date());
		tbContentMapper.insertSelective(content);
		return CommonResult.ok();
	}

	@Override
	public CommonResult updateContent(TbContent content) {
		content.setUpdated(new Date());
		tbContentMapper.updateByPrimaryKeySelective(content);
		//删除缓存
		HttpClientUtil.doGet(CMS_CACHE_SYNC+content.getCategoryId());
		return CommonResult.ok();
	}

}
