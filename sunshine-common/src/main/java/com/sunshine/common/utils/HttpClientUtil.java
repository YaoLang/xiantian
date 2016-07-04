package com.sunshine.common.utils;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * http访问工具
 * @author yaolang
 *
 */
public class HttpClientUtil {

	public static String doGet(String url,Map<String,String> params){
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpGet get = new HttpGet();
		CloseableHttpResponse response = null;
		
		try {
			URIBuilder uriBuilder = new URIBuilder(url);
			if(params!=null){
				for(String key : params.keySet()){
					uriBuilder.setParameter(key, params.get(key));
				}
			}
			URI uri = uriBuilder.build();
			get.setURI(uri);
			response = httpClient.execute(get);
			if(response.getStatusLine().getStatusCode()==200){
				return EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(response!=null)
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	public static String doGet(String url){
		return doGet(url, null);
	}
	
	public static String doPost(String url, Map<String, String> param) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			// 创建参数列表
			if (param != null) {
				List<NameValuePair> paramList = new ArrayList<>();
				for (String key : param.keySet()) {
					paramList.add(new BasicNameValuePair(key, param.get(key)));
				}
				// 模拟表单
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
				httpPost.setEntity(entity);
			}
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return resultString;
	}

	public static String doPost(String url) {
		return doPost(url, null);
	}
	
	public static String doPostJson(String url, String json) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			// 创建请求内容
			StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
			httpPost.setEntity(entity);
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return resultString;
	}
	
	public static String doDelete(String url,Map<String, String> params){
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpDelete delete = new HttpDelete();
		CloseableHttpResponse response = null;
		
		try {
			URIBuilder uriBuilder = new URIBuilder(url);
			if(params!=null){
				for(String key : params.keySet()){
					uriBuilder.setParameter(key, params.get(key));
				}
			}
			URI uri = uriBuilder.build();
			delete.setURI(uri);
			response = httpClient.execute(delete);
			if(response.getStatusLine().getStatusCode()==200){
				return EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(response!=null)
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	public static String doDelete(String url){
		return doDelete(url, null);
	}
	
	public static String doPut(String url,Map<String, String> params){
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpPut put = new HttpPut();
		CloseableHttpResponse response = null;
		
		try {
			URIBuilder uriBuilder = new URIBuilder(url);
			if(params!=null){
				for(String key : params.keySet()){
					uriBuilder.setParameter(key, params.get(key));
				}
			}
			URI uri = uriBuilder.build();
			put.setURI(uri);
			response = httpClient.execute(put);
			if(response.getStatusLine().getStatusCode()==200){
				return EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(response!=null)
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	
	
	public static String doPut(String url){
		return doPut(url, null);
	}
}
