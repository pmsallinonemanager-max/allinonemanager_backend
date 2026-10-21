package com.mobile.allinonemanager.request.dto;
import lombok.Data;

@Data
public class UpdateCreditCardRequest {

	private Integer ccId;

	private Integer userId;

	private String ccNumber;

	private String ccBank;

	private String ccName;

	private String ccType;

	private String expDate;

	private String cvv;

	private String nameOnCard;

	private String statementDate;

	private String dueDate;

	private String ccLimit;

}
