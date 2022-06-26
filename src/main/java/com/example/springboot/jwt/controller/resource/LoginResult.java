package com.example.springboot.jwt.controller.resource;


public class LoginResult {
	
	public LoginResult(String jwt) {
		this.token = jwt;
	}

	private String token;
}
