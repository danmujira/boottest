package com.example.demo.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class TestService {
	
	private final RedisTemplate redisTemplate;
	
	public void insertCache(String p1) {
		ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
		valueOperations.set("1", p1);
		log.info("{}", valueOperations.get("1"));
	}
	
	public String getCache(String param1) {
		return ((ValueOperations<String, String>)redisTemplate.opsForValue()).get(param1);
	}

}
