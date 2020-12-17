package com.ibm.order.controller;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	private static final String template = "Welcome %s!, Your Access token is %s";

	@RequestMapping("/welcome")
	public String welcomeMessage(@RequestParam(value="name", defaultValue = "User") String name,
			@AuthenticationPrincipal Jwt accessToken) {
		
		return String.format(template, name, accessToken.getClaims().get("sub"));
		
	}
	

}
