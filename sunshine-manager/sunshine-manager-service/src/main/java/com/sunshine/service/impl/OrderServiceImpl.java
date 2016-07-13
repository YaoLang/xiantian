package com.sunshine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshine.mapper.TbOrderItemMapper;
import com.sunshine.mapper.TbOrderMapper;
import com.sunshine.mapper.TbOrderShippingMapper;
import com.sunshine.pojo.TbOrder;
import com.sunshine.pojo.TbOrderExample;
import com.sunshine.pojo.TbOrderItem;
import com.sunshine.pojo.TbOrderItemExample;
import com.sunshine.pojo.TbOrderShipping;
import com.sunshine.pojo.TbOrderShippingExample;
import com.sunshine.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private TbOrderMapper tbOrderMapper;
	
	@Autowired
	private TbOrderItemMapper tbOrderItemMapper;
	
	@Autowired
	private TbOrderShippingMapper tbOrderShippingMapper;
	
	@Override
	public TbOrder getOrderById(String orderid) {
		return tbOrderMapper.selectByPrimaryKey(orderid);
	}

	@Override
	public List<TbOrderItem> getOrderItemsByOid(String orderid) {
		TbOrderItemExample example = new TbOrderItemExample();
		example.createCriteria().andOrderIdEqualTo(orderid);
		return tbOrderItemMapper.selectByExample(example);
	}

	@Override
	public TbOrderShipping gerOrderShippingByOid(String orderid) {
		return tbOrderShippingMapper.selectByPrimaryKey(orderid);
	}

	@Override
	public List<TbOrder> getAllOrder(Integer status) {
		TbOrderExample example = new TbOrderExample();
		example.createCriteria().andStatusEqualTo(status);
		return tbOrderMapper.selectByExample(example);
	}

	@Override
	public List<TbOrderShipping> getAllOrderShipping() {
		TbOrderShippingExample example = new TbOrderShippingExample();
		return tbOrderShippingMapper.selectByExample(example);
	}

}
