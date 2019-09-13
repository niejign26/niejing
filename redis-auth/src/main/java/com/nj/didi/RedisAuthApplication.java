package com.nj.didi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class RedisAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisAuthApplication.class, args);
	}

}
