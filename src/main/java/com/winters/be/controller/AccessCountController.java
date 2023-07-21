package com.winters.be.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.winters.be.entity.AccessCount;
import com.winters.be.service.AccessCountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AccessCountController {
	private final AccessCountService accessCountService;
	
	@PostMapping("/AccessCount")
	AccessCount getAccessCountInfo(@RequestBody Map<String,String> bodyMap) {
		
		return accessCountService.getAccessCount(bodyMap.get("ipAddr"));
	}
}
