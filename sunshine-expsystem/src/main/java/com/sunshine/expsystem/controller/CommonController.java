package com.sunshine.expsystem.controller;

import com.sunshine.common.pojo.CommonResult;
import com.sunshine.expsystem.service.AdminService;
import com.sunshine.expsystem.service.EssayService;
import com.sunshine.expsystem.service.NoteService;
import com.sunshine.pojo.TbAdmin;
import com.sunshine.pojo.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/common")
@Controller
public class CommonController {

	@Autowired
	private NoteService noteService;

	@Autowired
	private EssayService essayService;

	@Autowired
	private AdminService adminService;

	@RequestMapping("/header")
	public String header(HttpServletRequest req,Model model){
		TbAdmin user = adminService.getUserByRequst(req);
		if(user!=null)
			model.addAttribute("uname", user.getUsername());
		return "/common/header";
	}
	
	@RequestMapping("/footer")
	public String footer(){
		return "/common/footer";
	}
	
	@RequestMapping("/slider")
	public String slider(Model model){
		CommonResult noteCates = noteService.getNoteCategories(0L);
		model.addAttribute("note",noteCates);
		CommonResult essayCates = essayService.getEssayCategories(0L,1);
		model.addAttribute("essay",essayCates);
		return "/common/slider";
	}
	
	@RequestMapping("/eueditor")
	public String eueditor(){
		return "/common/EUeditor";
	}
}
