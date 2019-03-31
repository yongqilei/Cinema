package com.movie.pncinema.us.config;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Pool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

@Configuration
public class LettuceRedisConfig {
	
//	@Autowired
//	private RedisProperties redisProperties;
//
//	@Autowired
//	private Pool pool;
//
//	@Bean
//	public LettuceConnectionFactory lettuceConnectionFactory(GenericObjectPoolConfig genericObjectPoolConfig) {
//		// 单机配置
////		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
////		redisStandaloneConfiguration.setDatabase(redisProperties.getDatabase());
////		redisStandaloneConfiguration.setHostName(redisProperties.getHost());
////		redisStandaloneConfiguration.setPort(redisProperties.getPort());
////		redisStandaloneConfiguration.setPassword(RedisPassword.of(redisProperties.getPassword()));
//		// 集群配置
//		RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
//		List<String> servers = redisProperties.getCluster().getNodes();
//		Set<RedisNode> nodes = new HashSet<>();
//		for(String ipAddress : servers) {
//			String[] ipAndPort = ipAddress.split(":");
//			nodes.add(new RedisNode(ipAndPort[0].trim(), Integer.valueOf(ipAndPort[1])));
//		}
//		redisClusterConfiguration.setClusterNodes(nodes);
//		redisClusterConfiguration.setMaxRedirects(redisProperties.getCluster().getMaxRedirects());
//
//		LettuceClientConfiguration clientConfig = LettucePoolingClientConfiguration.builder()
//				.commandTimeout(redisProperties.getTimeout())
//				.poolConfig(genericObjectPoolConfig)
//				.build();
//
//		if(redisProperties.isSsl()) {
//			clientConfig.isUseSsl();
//		}
//
//		LettuceConnectionFactory factory = new LettuceConnectionFactory(redisClusterConfiguration, clientConfig);
//
//		return factory;
//	}
//
//	@Bean
//	public GenericObjectPoolConfig genericObjectPoolConfig() {
//		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
//		config.setMaxTotal(pool.getMaxActive());
//		config.setMaxIdle(pool.getMaxIdle());
//		config.setMinIdle(pool.getMinIdle());
//		config.setMaxWaitMillis(pool.getMaxWait().toMillis());
//
//		return config;
//	}
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
		Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		// 配置RedisTemplate
		RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
		// 配置连接工厂
		redisTemplate.setConnectionFactory(lettuceConnectionFactory);
		
		RedisSerializer<String> serializer = new StringRedisSerializer();
		
		redisTemplate.setKeySerializer(serializer);
		redisTemplate.setValueSerializer(serializer);
		
		redisTemplate.setHashKeySerializer(jackson2JsonRedisSerializer);
		redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
		
		redisTemplate.setEnableTransactionSupport(true);
		redisTemplate.afterPropertiesSet();
		
		return redisTemplate;
	}
}
