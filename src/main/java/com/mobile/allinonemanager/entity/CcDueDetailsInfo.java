package com.mobile.allinonemanager.entity;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cc_due_details_info")
public class CcDueDetailsInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cc_due_id")
	private Integer ccDueId;

	@Column(name = "cc_id")
	private Integer ccId;

	@Column(name = "due_amt")
	private Double dueAmt;

	@Column(name = "minimum_due")
	private Double minimumDue;

	@Column(name = "total_outstanding")
	private Double totalOutstanding;

	@Column(name = "statement_date")
	private LocalDate statementDate;

	@Column(name = "due_date")
	private LocalDate dueDate;

	@Column(name = "is_paid")
	private Boolean isPaid;

}
