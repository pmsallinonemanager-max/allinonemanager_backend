package com.mobile.allinonemanager.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "credit_card_info")
public class CreditCardInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cc_id")
	private Integer ccId;

	@Column(name = "cc_number")
	private String ccNumber;

	@Column(name = "cc_bank")
	private String ccBank;

	@Column(name = "cc_name")
	private String ccName;

	@Column(name = "cc_type")
	private String ccType;

	@Column(name = "exp_date")
	private String expDate;

	@Column(name = "cvv")
	private String cvv;

	@Column(name = "name_on_card")
	private String nameOnCard;

	@Column(name = "statement_date")
	private String statementDate;

	@Column(name = "due_date")
	private String dueDate;

	@Column(name = "cc_limit")
	private String ccLimit;

	@Column(name = "user_id")
	private Integer userId;

}
