package com.winters.be;

import com.winters.be.service.AccessCountService;
import lombok.RequiredArgsConstructor;

//@Controller
@RequiredArgsConstructor
public class HomeController {
	private final AccessCountService accessCounterService;
	
//	@RequestMapping({"","/"})
//	public String home() {
//		System.out.println("home: ");
//		return "/index";
//	}
//	@RequestMapping({"/test"})
//	public String test() {
//		System.out.println("test: ");
//		return "/test";
//	}
}
