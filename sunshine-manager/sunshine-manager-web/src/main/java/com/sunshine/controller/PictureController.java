package com.sunshine.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sunshine.common.utils.JsonUtils;
import com.sunshine.service.PictureService;

@Controller
public class PictureController {

	@Autowired
	private PictureService pictureService;
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String uploadPicture(MultipartFile multipartFile){
		Map resultMap = pictureService.uploadPicture(multipartFile);
		String result = JsonUtils.objectToJson(resultMap);
		return result;
	}
}
