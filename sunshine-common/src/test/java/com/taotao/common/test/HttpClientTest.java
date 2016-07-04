package com.taotao.common.test;


import com.sunshine.common.utils.HttpClientUtil;

public class HttpClientTest {
	
	
	
	public static void main(String[] args) {
		String json = HttpClientUtil.doPut("http://localhost:8081/rest/cart/moni");
		System.out.println(json);
	}
	
//	@Test
//	public void testContent(){
//		String json = HttpClientUtil.doGet("http://127.0.0.1:8081/rest/content/list/89");
//		System.out.println(json);
//		System.out.println(123);
//	}
}
