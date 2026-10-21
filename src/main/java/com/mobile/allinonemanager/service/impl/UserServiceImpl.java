package com.mobile.allinonemanager.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.allinonemanager.entity.Users;
import com.mobile.allinonemanager.repo.UserRepo;
import com.mobile.allinonemanager.request.dto.LoginRequest;
import com.mobile.allinonemanager.request.dto.SignUpRequest;
import com.mobile.allinonemanager.response.dto.LoginResponse;
import com.mobile.allinonemanager.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public LoginResponse loginUser(LoginRequest loginRequest) {
		Users user = userRepo.findByMobileAndPassword(loginRequest.getMobile(), loginRequest.getPassword());
		if(user != null) {
			return new LoginResponse("Login successful.", user.getUserId());
		}
		return new LoginResponse("Please check your mobile number and password or Signup.", null);
	}

	@Override
	public String signupUser(SignUpRequest signUpRequest) {
		Users user = new Users();
		user.setMobile(signUpRequest.getMobile());
		user.setPassword(signUpRequest.getPassword());
		user.setFullName(signUpRequest.getFullName());
		user.setEmail(signUpRequest.getEmail());
		userRepo.save(user);
		return "User registered successfully.";
	}

}
