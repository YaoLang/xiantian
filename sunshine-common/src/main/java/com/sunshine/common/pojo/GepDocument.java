package com.sunshine.common.pojo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 数据文档
 * @author yaolang
 *
 */
public class GepDocument {
	
	private Map<String, Object> map = new LinkedHashMap<String, Object>();
	
	private String id;
	
	public void addItem(String key,Object value){
		map.put(key, value==null?"0":value);
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
