package com.sunshine.common.utils;

import com.sunshine.common.pojo.CommonResult;
import com.sunshine.common.pojo.GepDocument;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GepClient {

	private String host;
	private Integer port;
	
	public GepClient(String host,Integer port){
		this.host = host;
		this.port = port;
	}
	
	public long saveDocument(GepDocument gepDocument) throws Exception{
		String url = "http://"+host+":"+port+"/gep/save";
		String json  = HttpClientUtil.doPostJson(url,JsonUtils.objectToJson(gepDocument));
		CommonResult commonResult = CommonResult.format(json);
		if(commonResult.getStatus().equals(400))
			throw new Exception("can not unset the label");
		return 0;
	}
	
	public String riskPredict(GepDocument gepDocument){
		String url = "http://"+host+":"+port+"/gep/symptom";
		String json = HttpClientUtil.doPostJson(url,JsonUtils.objectToJson(gepDocument));
		return json;
	}

	public String symptomWeight(String topic,String risk){
		String url = "http://"+host+":"+port+"/gep/risk";
		Map<String,String> params = new HashMap<>();
		params.put("topic",topic);
		params.put("risk",risk);
		String json = HttpClientUtil.doPost(url,params);
		return json;
	}

	public List<String> getTopics(String topic){
		String url = "http://"+host+":"+port+"/gep/symptomtopics";
		Map<String,String> params = new HashMap<>();
		params.put("topic",topic);
		String json = HttpClientUtil.doGet(url, params);
		CommonResult result = CommonResult.formatToList(json, String.class);
		List<String> topics = (List<String>) result.getData();
		return topics;
	}

	public List<String> getSymtomsByTopicField(String topic,String field){
		String url = "http://"+host+":"+port+"/gep/symptomcats";
		Map<String,String> params = new HashMap<>();
		params.put("topic",topic);
		params.put("field",field);
		String json = HttpClientUtil.doGet(url, params);
		CommonResult result = CommonResult.formatToList(json, String.class);
		List<String> topics = (List<String>) result.getData();
		return topics;
	}

}
