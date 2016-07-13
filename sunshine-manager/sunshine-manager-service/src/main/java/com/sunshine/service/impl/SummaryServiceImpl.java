package com.sunshine.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshine.mapper.TbItemMapper;
import com.sunshine.mapper.TbOrderMapper;
import com.sunshine.mapper.TbUserMapper;
import com.sunshine.pojo.TbItemExample;
import com.sunshine.pojo.TbOrderExample;
import com.sunshine.pojo.TbUserExample;
import com.sunshine.service.SummaryService;

@Service
public class SummaryServiceImpl implements SummaryService{

	@Autowired
	private TbUserMapper tbUserMapper;
	
	@Autowired
	private TbOrderMapper tbOrderMapper;
	
	@Autowired
	private TbItemMapper tbItemMapper;
	
	@Override
	public Integer countUser() {
		TbUserExample example = new TbUserExample();
		return tbUserMapper.countByExample(example);
	}

	@Override
	public Integer countOrder() {
		TbOrderExample example = new TbOrderExample();
		return tbOrderMapper.countByExample(example);
	}

	@Override
	public Integer countItems(Integer status) {
		TbItemExample example = new TbItemExample();
		return tbItemMapper.countByExample(example);
	}

	@Override
	public Integer countNewClient() {
		Date now = new Date();
		TbUserExample example = new TbUserExample();
		example.createCriteria().andCreatedLessThan(now);
		return tbUserMapper.countByExample(example);
	}

}
