package com.nj.didi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nj.didi.utils.RedisManager;

@Service
public class AuthService {

	@Autowired
	private RedisManager redisManager;
	
	public void insert(String userName,String passWord){
		redisManager.set(userName.getBytes(), passWord.getBytes(),1000);
	}
	
	public String getValue(String userName){
		byte[] value=redisManager.get(userName.getBytes());
		return value.toString();
	}
	
}
