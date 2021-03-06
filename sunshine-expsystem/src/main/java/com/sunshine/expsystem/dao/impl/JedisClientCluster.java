package com.sunshine.expsystem.dao.impl;

import com.sunshine.expsystem.dao.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisCluster;

public class JedisClientCluster implements JedisClient {

	@Autowired
	private JedisCluster jedisCluster;
	
	@Override
	public String get(String key) {
		String value = jedisCluster.get(key);
		return value;
	}

	@Override
	public String set(String key, String value) {
		String result = jedisCluster.set(key, value);
		return result;
	}

	@Override
	public String hget(String hkey, String key) {
		String result = jedisCluster.hget(hkey, key);
		return result;
	}

	@Override
	public long hset(String hkey, String key, String value) {
		long result = jedisCluster.hset(hkey, key, value);
		return result;
	}

	@Override
	public long incr(String key) {
		long result = jedisCluster.incr(key);
		return result;
	}

	@Override
	public long expire(String key, int second) {
		long result = jedisCluster.expire(key, second);
		return result;
	}

	@Override
	public long ttl(String key) {
		long result = jedisCluster.ttl(key);
		return result;
	}

	@Override
	public long del(String key) {
		long result = jedisCluster.del(key);
		return result;
	}

	@Override
	public long hdel(String hkey, String key) {
		long result = jedisCluster.hdel(hkey, key);
		return result;
	}

}
