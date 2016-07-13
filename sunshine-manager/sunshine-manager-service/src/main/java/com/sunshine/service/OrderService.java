package com.sunshine.service;

import java.util.List;

import com.sunshine.pojo.TbOrder;
import com.sunshine.pojo.TbOrderItem;
import com.sunshine.pojo.TbOrderShipping;

public interface OrderService {

	public TbOrder getOrderById(String orderid);
	
	public List<TbOrderItem> getOrderItemsByOid(String orderid);
	
	public TbOrderShipping gerOrderShippingByOid(String orderid);

	public List<TbOrder> getAllOrder(Integer status);

	public List<TbOrderShipping> getAllOrderShipping();
}
