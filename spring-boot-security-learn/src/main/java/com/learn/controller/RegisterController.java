package com.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.model.Users;
import com.learn.service.UserService;

@RestController
@RequestMapping("/")
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public Users register(@RequestBody Users user) {
		return userService.register(user);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Users user) {
		
		return userService.verify(user);
	}

}
