package com.mobile.allinonemanager.service;

import com.mobile.allinonemanager.request.dto.LoginRequest;
import com.mobile.allinonemanager.request.dto.SignUpRequest;

public interface UserService {

	String loginUser(LoginRequest loginRequest);

	String signupUser(SignUpRequest signUpRequest);

}
