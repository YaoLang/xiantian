package com.sunshine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunshine.common.pojo.CommonResult;

@RequestMapping("/chart")
@Controller
public class ChartController {

	
	@RequestMapping("/show")
	public String chart(){
		return "chart";
	}
	
	@RequestMapping("/realtime/{x}")
	@ResponseBody
	public CommonResult RealTimeData(@PathVariable Integer x){
		/*Double y = Math.tan(x);
		System.out.println(y);*/
		return CommonResult.ok(time());
	}
	
	private double time(){
		double r = Math.random();
		return Math.tan(r);
	}
}
