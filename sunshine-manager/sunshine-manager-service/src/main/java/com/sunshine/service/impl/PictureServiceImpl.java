package com.sunshine.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sunshine.common.utils.FtpUtil;
import com.sunshine.common.utils.IDUtils;
import com.sunshine.service.PictureService;

@Service
public class PictureServiceImpl implements PictureService{

	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	@Value("${FTP_PORT}")
	private String FTP_PORT;
	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;


	
	@Override
	public Map uploadPicture(MultipartFile multipartFile) {
		
		System.out.println("value of port "+FTP_PORT);
		Map resultMap = new HashMap<>();
		String oldname = multipartFile.getName();
		String newname = IDUtils.genImageName();
		newname=newname+oldname.substring(oldname.lastIndexOf(','));
		
		String imagepath = new DateTime().toString("/yyyy/MM/dd");
		try {
			boolean result = FtpUtil.uploadFile(FTP_ADDRESS, Integer.valueOf(FTP_PORT), FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH, imagepath, newname, multipartFile.getInputStream());
		
			if(!result){
				resultMap.put("error", 1);
				resultMap.put("message", "upload failed");
				return resultMap;
			}
			resultMap.put("error", 0);
			resultMap.put("url", IMAGE_BASE_URL + imagepath + "/" + newname);
		} catch (IOException e) {
			resultMap.put("error", 1);
			resultMap.put("message", "error occur when upload file");
			return resultMap;
		}
		
		return resultMap;
	}

	
}
