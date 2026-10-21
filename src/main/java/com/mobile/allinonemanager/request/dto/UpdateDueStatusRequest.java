package com.mobile.allinonemanager.request.dto;
import lombok.Data;

@Data
public class UpdateDueStatusRequest {

	private Integer ccDueId;

	private Boolean isPaid;

}
