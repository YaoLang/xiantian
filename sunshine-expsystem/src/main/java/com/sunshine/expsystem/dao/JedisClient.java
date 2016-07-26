package com.sunshine.expsystem.dao;

public interface JedisClient {
	/**
	 * 获取key
	 * @param key
	 * @return
	 */
	String get(String key);
	
	/**
	 * 设置key
	 * @param key
	 * @param value
	 * @return
	 */
	String set(String key, String value);
	
	/**
	 * 
	 * @param hkey
	 * @param key
	 * @return
	 */
	String hget(String hkey, String key);
	
	/**
	 * 
	 * @param hkey
	 * @param key
	 * @param value
	 * @return
	 */
	long hset(String hkey, String key, String value);
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	long incr(String key);
	
	/**
	 * 
	 * @param key
	 * @param second
	 * @return
	 */
	long expire(String key, int second);
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	long ttl(String key);
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	long del(String key);
	
	/**
	 * 
	 * @param hkey
	 * @param key
	 * @return
	 */
	long hdel(String hkey, String key);

	/**
	 * 认证
	 * @param password
	 * @return
	 */
	String auth(String password);
}
