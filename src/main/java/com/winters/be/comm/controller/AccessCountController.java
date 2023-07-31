package com.winters.be.comm.controller;

import com.winters.be.db.entity.AccessCountEntity;
import com.winters.be.service.AccessCountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AccessCountController {
	private final AccessCountService accessCountService;
	
	@PostMapping("/AccessCount")
	AccessCountEntity getAccessCountInfo(@RequestBody Map<String,String> bodyMap) {
		
		return accessCountService.getAccessCount(bodyMap.get("ipAddr"));
	}
}
