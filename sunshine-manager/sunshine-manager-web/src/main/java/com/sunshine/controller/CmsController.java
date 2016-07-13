package com.sunshine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cms")
@Controller
public class CmsController {

	@RequestMapping("/show")
	public String powerpoint(){
		return "cms";
	}
}
