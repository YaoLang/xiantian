package com.sunshine.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshine.common.pojo.CommonResult;
import com.sunshine.mapper.TbItemParamMapper;
import com.sunshine.pojo.TbItemParam;
import com.sunshine.pojo.TbItemParamExample;
import com.sunshine.service.ItemParamService;

@Service
public class ItemParamServiceImpl implements ItemParamService{
	
	@Autowired
	private TbItemParamMapper tbItemParamMapper;
	
	
	@Override
	public CommonResult insertItemParam(TbItemParam itemParam) {
		Date date = new Date();
		itemParam.setCreated(date);
		itemParam.setUpdated(date);
		tbItemParamMapper.insert(itemParam);
		return CommonResult.ok();
	}

	@Override
	public CommonResult getItemParamByCid(long cid) {
		CommonResult taotaoResult = new CommonResult();
		TbItemParamExample example = new TbItemParamExample();
		example.createCriteria().andItemCatIdEqualTo(cid);
		List list = tbItemParamMapper.selectByExample(example);
		if(list!=null&&list.size()>0)
			return taotaoResult.ok(list.get(0));
		return taotaoResult.ok();
	}

}
