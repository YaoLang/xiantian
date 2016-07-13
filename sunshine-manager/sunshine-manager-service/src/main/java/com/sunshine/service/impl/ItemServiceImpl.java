package com.sunshine.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunshine.common.pojo.CommonResult;
import com.sunshine.common.pojo.EUDataGridResult;
import com.sunshine.common.utils.IDUtils;
import com.sunshine.mapper.TbItemDescMapper;
import com.sunshine.mapper.TbItemMapper;
import com.sunshine.mapper.TbItemParamItemMapper;
import com.sunshine.pojo.TbItem;
import com.sunshine.pojo.TbItemDesc;
import com.sunshine.pojo.TbItemExample;
import com.sunshine.pojo.TbItemParamItem;
import com.sunshine.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	public TbItemMapper tbItemMapper;
	
	@Autowired
	public TbItemDescMapper tbItemDescMapper;
	
	@Autowired
	public TbItemParamItemMapper tbItemParamItemMapper;
	
	@Override
	public TbItem getItemById(Long itemid) {
		return tbItemMapper.selectByPrimaryKey(itemid);
	}

	@Override
	public EUDataGridResult getItemList(int page, int rows) {
		TbItemExample itemExample = new TbItemExample();
		PageHelper.startPage(page, rows);
		List<TbItem> result = tbItemMapper.selectByExample(itemExample);
		
		EUDataGridResult euDataGridResult = new EUDataGridResult();
		euDataGridResult.setRows(result);
		PageInfo<TbItem> pageInfo = new PageInfo<>(result);
		euDataGridResult.setTotal(pageInfo.getTotal());
		
		return euDataGridResult;
	}

	@Override
	public CommonResult createItem(TbItem item, String desc, String itemParams) throws Exception {
		Date date = new Date();
		long itemid = IDUtils.genItemId();
		item.setId(itemid);
		item.setStatus((byte)1); //1 正常
		item.setCreated(date);
		item.setUpdated(date);
		
	
		
		tbItemMapper.insert(item);
		
		CommonResult descresult = insertItemDesc(itemid, desc);
		if(descresult.getStatus()!=200)
			throw new Exception();
		
		CommonResult paramresult = insertItemParamItem(itemid, itemParams);
		if(paramresult.getStatus()!=200)
			throw new Exception();
		
		return CommonResult.ok();
	}

	
	private CommonResult insertItemDesc(long itemid,String desc){
		TbItemDesc itemDesc = new TbItemDesc();
		Date date = new Date();
		itemDesc.setCreated(date);
		itemDesc.setUpdated(date);
		itemDesc.setItemDesc(desc);
		itemDesc.setItemId(itemid);
		tbItemDescMapper.insert(itemDesc);
		return CommonResult.ok();
	}
	
	private CommonResult insertItemParamItem(long itemid,String itemParams){
		TbItemParamItem itemParamItem = new TbItemParamItem();
		itemParamItem.setId(itemid);
		itemParamItem.setParamData(itemParams);
		Date date = new Date();
		itemParamItem.setCreated(date);
		itemParamItem.setUpdated(date);
		return CommonResult.ok();
	}

	@Override
	public CommonResult getAllItem() {
		TbItemExample itemExample = new TbItemExample();
		List<TbItem> result = tbItemMapper.selectByExample(itemExample);
		return CommonResult.ok(result);
	}
}
