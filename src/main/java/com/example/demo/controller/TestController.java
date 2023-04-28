package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.expression.Strings;

import com.example.demo.service.TestService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/test")
@Slf4j
public class TestController {
	private final TestService testService;
	
	@PostMapping("")
	public void insertCache(@RequestBody Map<String, String> p1) {
		log.info("req={}", p1);
		testService.insertCache(p1.get("data"));
		
	}
	
	@GetMapping("")
	public String getCache(@RequestParam String key) {
		log.info("req={}", key);
		return testService.getCache(key);
	}
}
