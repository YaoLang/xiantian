package com.sunshine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunshine.pojo.TbOrder;
import com.sunshine.pojo.TbOrderItem;
import com.sunshine.pojo.TbOrderShipping;
import com.sunshine.service.OrderService;

@RequestMapping("/order")
@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/{orderid}")
	public String orderdetail(@PathVariable String orderid,Model model){
		TbOrder order = orderService.getOrderById(orderid);
		List<TbOrderItem> orderItems = orderService.getOrderItemsByOid(orderid);
		TbOrderShipping orderShipping  = orderService.gerOrderShippingByOid(orderid);
		model.addAttribute("order", order);
		model.addAttribute("orderitems", orderItems);
		model.addAttribute("shipping", orderShipping);
		return "orderdetail";
	}
	
	@RequestMapping("/list/{status}")
	public String orderlist(@PathVariable Integer status,Model model){
		if(status==0)
			model.addAttribute("comment", "新订单");
		if(status==1)
			model.addAttribute("comment", "发货");
		if(status==2)
			model.addAttribute("comment", "已成交订单");
		
		List<TbOrder> orders = orderService.getAllOrder(status);
		model.addAttribute("orders",orders);
		return "order";
	}
}
