package com.sunshine.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface PictureService {
	/**
	 * 上传图片
	 * @param multipartFile 文件
	 * @return
	 */
	public Map uploadPicture(MultipartFile multipartFile);
}
