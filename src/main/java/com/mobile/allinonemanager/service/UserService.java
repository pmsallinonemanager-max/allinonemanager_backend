package com.mobile.allinonemanager.service;

import com.mobile.allinonemanager.request.dto.LoginRequest;
import com.mobile.allinonemanager.request.dto.SignUpRequest;
import com.mobile.allinonemanager.response.dto.LoginResponse;

public interface UserService {

	LoginResponse loginUser(LoginRequest loginRequest);

	String signupUser(SignUpRequest signUpRequest);

}
