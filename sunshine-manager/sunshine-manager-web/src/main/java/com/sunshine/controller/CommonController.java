package com.sunshine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/common")
@Controller
public class CommonController {

	@RequestMapping("header")
	public String header(){
		return "/common/header";
	}
	
	@RequestMapping("/footer")
	public String footer(){
		return "/common/footer";
	}
	
	@RequestMapping("/slider")
	public String slider(){
		return "/common/slider";
	}
	
	@RequestMapping("/eueditor")
	public String eueditor(){
		return "/common/EUeditor";
	}
}
