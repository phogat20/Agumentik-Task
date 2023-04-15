package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContoller {

	@GetMapping("/user")
	private String user() {
		return "<h1>You are welcomed! </h1>" + " <br> <hr>" + "<h3> You have user role </h3>";
	}

	@GetMapping("/admin")
	private String admin() {
		return "<h1>You are welcomed! </h1>" + " <br> <hr>" + "<h3> You have admin role </h3>";
	}
	

}
