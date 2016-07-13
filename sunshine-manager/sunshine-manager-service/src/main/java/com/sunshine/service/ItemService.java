package com.sunshine.service;

import com.sunshine.common.pojo.EUDataGridResult;
import com.sunshine.common.pojo.CommonResult;
import com.sunshine.pojo.TbItem;

public interface ItemService {
	public TbItem getItemById(Long itemid);
	
	public EUDataGridResult getItemList(int page,int rows);
	
	public CommonResult createItem(TbItem item,String desc,String itemParams) throws Exception;
	
	public CommonResult getAllItem();
}
