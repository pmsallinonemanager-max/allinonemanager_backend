package com.mobile.allinonemanager.request.dto;
import lombok.Data;

@Data
public class SignUpRequest {
	
	private String fullName;
	
	private String mobile;
	
	private String email;
	
	private String password;
	
}
