package com.movie.pncinema.utils.redis;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtils {

	private static final long DEFAULT_EXPIRE = 6000L;

	private static final String LOCK_PREFIX = "SYS:DISTRIBUTED:LOCK:";

	private static final Logger LOG = LoggerFactory.getLogger(RedisUtils.class);

	@Autowired
	private RedisTemplate<String,Object> template;

	private static RedisTemplate<String,Object> redisTemplate;

	public static RedisUtils redisTemplateUtils;
	
	@PostConstruct
	public void init() {
		LOG.info("初始化Redis Utility工具类。");
		redisTemplateUtils = this;
		redisTemplateUtils.template = this.template;
		redisTemplate = this.template;
	}
	
	public static boolean exists(String key) {
		return redisTemplate.hasKey(key);
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
		}
		
		return result;
	}
	
	public static Object get(String key) {
		try {
			return redisTemplate.opsForValue().get(key);
		} catch (Exception e) {
			LOG.error("获取 key { %s } 的数据失败！", key);
			return null;
		}
	}

	public static boolean lock(String lockName) {
		String lock = LOCK_PREFIX + lockName;

		return redisTemplate.execute((RedisCallback<Boolean>)  connection -> {
			long expireAt = System.currentTimeMillis() + DEFAULT_EXPIRE + 1;
			Boolean acquire = connection.setNX(lock.getBytes(), String.valueOf(1).getBytes());

			if (acquire) {
				connection.expireAt(lock.getBytes(), expireAt);
				return true;
			}
			return false;
		});

	}
	
}
