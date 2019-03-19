package com.movie.pncinema.utils.redis;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisTemplateUtils {

	@Autowired
	private RedisTemplate<String,Object> template;
	
	private static RedisTemplate<String,Object> redisTemplate;
	
	private static final Logger LOG = LoggerFactory.getLogger(RedisTemplateUtils.class);
	
	@PostConstruct
	public void init() {
		redisTemplate = this.template;
	}
	
	public static boolean exists(String key) {
		try {
			return redisTemplate.hasKey(key);
		} finally {
			RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
		}
	}
	
	public static boolean set(String key, Object obj, Long seconds) {
		boolean result = false;
		try {
			redisTemplate.opsForValue().set(key, obj);
			if(seconds > 0) {
				redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
			}
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
		}
		return result;
	}
	
	public static boolean del(String key) {
		boolean result = false;
		try {
			redisTemplate.delete(key);
			result = true;
		} catch (Exception e) {
			LOG.error("remove data by key { %s } failed, please retry later!", key);
			e.printStackTrace();
			result = false;
		} finally {
			RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
		}
		
		return result;
	}
	
	public static Object get(String key) {
		try {
			return redisTemplate.opsForValue().get(key);
		} catch (Exception e) {
			LOG.error("获取 key { %s } 的数据失败！", key);
			return null;
		} finally {
			RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
		}
	}
	
}
