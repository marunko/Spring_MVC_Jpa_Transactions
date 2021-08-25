package com.restmvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("/")
	public String index() {
		String string = "<h1>"+"Hello"+"</h1>" + "<a href="+"/persons"+">To all employees</a>";
		return string;
	}
}
