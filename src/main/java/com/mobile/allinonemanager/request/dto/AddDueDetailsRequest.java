package com.mobile.allinonemanager.request.dto;
import java.time.LocalDate;

import lombok.Data;

@Data
public class AddDueDetailsRequest {

	private Integer ccId;

	private Double dueAmt;

	private Double minimumDue;

	private Double totalOutstanding;

	private LocalDate statementDate;

	private LocalDate dueDate;

	private Boolean isPaid;

}
