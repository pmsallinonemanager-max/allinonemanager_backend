package com.mobile.allinonemanager.response.dto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {

	private String message;

	private Integer userId;

}
