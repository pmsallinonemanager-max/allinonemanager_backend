package com.mobile.allinonemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.allinonemanager.request.dto.LoginRequest;
import com.mobile.allinonemanager.request.dto.SignUpRequest;
import com.mobile.allinonemanager.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
		String response = userService.loginUser(loginRequest);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> signupUser(@RequestBody SignUpRequest signUpRequest) {
		String response = userService.signupUser(signUpRequest);
		return ResponseEntity.ok(response);
	}

}
