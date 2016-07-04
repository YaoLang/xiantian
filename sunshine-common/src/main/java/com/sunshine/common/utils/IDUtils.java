package com.sunshine.common.utils;

import java.util.Random;

/**
 * ID生成器
 * @author yaolang
 *
 */
public class IDUtils {

	/**
	 * 图片名生成
	 */
	public static String genImageName() {
		long millis = System.currentTimeMillis();
		Random random = new Random();
		int end3 = random.nextInt(999);
		String str = millis + String.format("%03d", end3);
		return str;
	}
	
	/**
	 * 商品id生成
	 */
	public static long genItemId() {
		long millis = System.currentTimeMillis();
		Random random = new Random();
		int end2 = random.nextInt(99);
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}
	
	
}
