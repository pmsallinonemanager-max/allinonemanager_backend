package com.mobile.allinonemanager.request.dto;
import lombok.Data;

@Data
public class UpdateCreditCardStatusRequest {

	private Integer ccId;

	private Boolean isActive;

}
