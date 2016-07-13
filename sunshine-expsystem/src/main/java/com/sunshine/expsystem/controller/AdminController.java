package com.sunshine.expsystem.controller;

import com.sunshine.common.pojo.CommonResult;
import com.sunshine.expsystem.service.AdminService;
import com.sunshine.pojo.TbAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/user")
@Controller
public class AdminController {

	@Autowired
	private AdminService userService;

	@RequestMapping("/check/{content}/{type}")
	@ResponseBody
	public Object checkData(@PathVariable String content,@PathVariable Integer type,String callback){
		CommonResult value = userService.checkData(content, type);
		if(callback==null)
			return value;
		MappingJacksonValue jacksonValue = new MappingJacksonValue(value);
		jacksonValue.setJsonpFunction(callback);
		
		return jacksonValue;
	}
	
/*	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ResponseBody
	public CommonResult createUser(TbAdmin tbUser){
		try {
			//欠缺后台校验
			return userService.createUser(tbUser);
		} catch (Exception e) {
			return CommonResult.build(400, e.getMessage());
		}
	}*/
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	public CommonResult userLogin(String username,String password,HttpServletRequest req,HttpServletResponse resp){
		try {
			CommonResult result = userService.userLogin(username, password,req,resp);
			return result;
		} catch (Exception e) {
			return CommonResult.build(400, e.getMessage());
		}
	}
	
	@RequestMapping("/token/{token}")
	@ResponseBody
	public CommonResult getUserByToken(@PathVariable String token){
		try {
			return userService.getUserByToken(token);
		} catch (Exception e) {
			return CommonResult.build(400, e.getMessage());
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest req,HttpServletResponse resp){
		userService.logout(req,resp);
		return "login";
	}
}
