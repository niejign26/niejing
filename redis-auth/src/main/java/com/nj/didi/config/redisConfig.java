package com.nj.didi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nj.didi.utils.RedisManager;

/**
 * @author bootdo 1992lcg@163.com
 */
@Configuration
public class redisConfig {
	@Value("${spring.redis.host}")
	private String host;
	@Value("${spring.redis.password}")
	private String password;
	@Value("${spring.redis.port}")
	private int port;
	@Value("${spring.redis.timeout}")
	private int timeout;

	@Bean
	public RedisManager redisManager() {
		RedisManager redisManager = new RedisManager();
		redisManager.setHost(host);
		redisManager.setPort(port);
		redisManager.setExpire(1800);// 配置缓存过期时间
		// redisManager.setTimeout(1800);
		redisManager.setPassword(password);

		redisManager.init();
		return redisManager;
	}

}
