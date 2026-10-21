package com.mobile.allinonemanager.response.dto;
import java.time.LocalDate;

import lombok.Data;

@Data
public class DueDetailsResponse {

	private Integer ccDueId;

	private Integer ccId;

	private String ccName;

	private String ccBank;

	private String ccNumberLast4;

	private Double dueAmt;

	private Double minimumDue;

	private Double totalOutstanding;

	private LocalDate statementDate;

	private LocalDate dueDate;

	private Boolean isPaid;

}
