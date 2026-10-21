package com.mobile.allinonemanager.service.impl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.allinonemanager.entity.CcDueDetailsInfo;
import com.mobile.allinonemanager.entity.CreditCardInfo;
import com.mobile.allinonemanager.repo.CcDueDetailsRepo;
import com.mobile.allinonemanager.repo.CreditCardRepo;
import com.mobile.allinonemanager.repo.UserRepo;
import com.mobile.allinonemanager.request.dto.AddCreditCardRequest;
import com.mobile.allinonemanager.request.dto.AddDueDetailsRequest;
import com.mobile.allinonemanager.request.dto.UpdateCreditCardRequest;
import com.mobile.allinonemanager.request.dto.UpdateDueDetailsRequest;
import com.mobile.allinonemanager.request.dto.UpdateDueStatusRequest;
import com.mobile.allinonemanager.response.dto.DueDetailsResponse;
import com.mobile.allinonemanager.service.CreditCardService;

@Service
public class CreditCardServiceImpl implements CreditCardService {

	@Autowired
	private CreditCardRepo creditCardRepo;

	@Autowired
	private CcDueDetailsRepo ccDueDetailsRepo;

	@Autowired
	private UserRepo userRepo;

	@Override
	public List<CreditCardInfo> getCreditCards(Integer userId) {
		return creditCardRepo.findByUserId(userId);
	}

	@Override
	public String addCreditCard(AddCreditCardRequest addCreditCardRequest) {
		if(addCreditCardRequest.getUserId() == null || !userRepo.existsById(addCreditCardRequest.getUserId())) {
			return "User not found.";
		}
		CreditCardInfo creditCard = new CreditCardInfo();
		creditCard.setUserId(addCreditCardRequest.getUserId());
		creditCard.setCcNumber(addCreditCardRequest.getCcNumber());
		creditCard.setCcBank(addCreditCardRequest.getCcBank());
		creditCard.setCcName(addCreditCardRequest.getCcName());
		creditCard.setCcType(addCreditCardRequest.getCcType());
		creditCard.setExpDate(addCreditCardRequest.getExpDate());
		creditCard.setCvv(addCreditCardRequest.getCvv());
		creditCard.setNameOnCard(addCreditCardRequest.getNameOnCard());
		creditCard.setStatementDate(addCreditCardRequest.getStatementDate());
		creditCard.setDueDate(addCreditCardRequest.getDueDate());
		creditCard.setCcLimit(addCreditCardRequest.getCcLimit());
		creditCardRepo.save(creditCard);
		return "Credit card added successfully.";
	}

	@Override
	public String updateCreditCard(UpdateCreditCardRequest updateCreditCardRequest) {
		if(updateCreditCardRequest.getCcId() == null || updateCreditCardRequest.getUserId() == null) {
			return "Credit card not found.";
		}
		Optional<CreditCardInfo> existingCard = creditCardRepo.findById(updateCreditCardRequest.getCcId());
		// Only the owner of the card may update it
		if(existingCard.isEmpty() || !updateCreditCardRequest.getUserId().equals(existingCard.get().getUserId())) {
			return "Credit card not found.";
		}
		// Partial update: only fields sent in the request are changed
		CreditCardInfo creditCard = existingCard.get();
		Optional.ofNullable(updateCreditCardRequest.getCcNumber()).ifPresent(creditCard::setCcNumber);
		Optional.ofNullable(updateCreditCardRequest.getCcBank()).ifPresent(creditCard::setCcBank);
		Optional.ofNullable(updateCreditCardRequest.getCcName()).ifPresent(creditCard::setCcName);
		Optional.ofNullable(updateCreditCardRequest.getCcType()).ifPresent(creditCard::setCcType);
		Optional.ofNullable(updateCreditCardRequest.getExpDate()).ifPresent(creditCard::setExpDate);
		Optional.ofNullable(updateCreditCardRequest.getCvv()).ifPresent(creditCard::setCvv);
		Optional.ofNullable(updateCreditCardRequest.getNameOnCard()).ifPresent(creditCard::setNameOnCard);
		Optional.ofNullable(updateCreditCardRequest.getStatementDate()).ifPresent(creditCard::setStatementDate);
		Optional.ofNullable(updateCreditCardRequest.getDueDate()).ifPresent(creditCard::setDueDate);
		Optional.ofNullable(updateCreditCardRequest.getCcLimit()).ifPresent(creditCard::setCcLimit);
		creditCardRepo.save(creditCard);
		return "Credit card updated successfully.";
	}

	@Override
	public String addDueDetails(AddDueDetailsRequest addDueDetailsRequest) {
		if(addDueDetailsRequest.getCcId() == null || !creditCardRepo.existsById(addDueDetailsRequest.getCcId())) {
			return "Credit card not found.";
		}
		CcDueDetailsInfo dueDetails = new CcDueDetailsInfo();
		dueDetails.setCcId(addDueDetailsRequest.getCcId());
		dueDetails.setDueAmt(addDueDetailsRequest.getDueAmt());
		dueDetails.setMinimumDue(addDueDetailsRequest.getMinimumDue());
		dueDetails.setTotalOutstanding(addDueDetailsRequest.getTotalOutstanding());
		dueDetails.setStatementDate(addDueDetailsRequest.getStatementDate());
		dueDetails.setDueDate(addDueDetailsRequest.getDueDate());
		dueDetails.setIsPaid(Boolean.TRUE.equals(addDueDetailsRequest.getIsPaid()));
		ccDueDetailsRepo.save(dueDetails);
		return "Due details added successfully.";
	}

	@Override
	public String updateDueDetails(UpdateDueDetailsRequest updateDueDetailsRequest) {
		if(updateDueDetailsRequest.getCcDueId() == null || updateDueDetailsRequest.getCcId() == null) {
			return "Due details not found.";
		}
		Optional<CcDueDetailsInfo> existingDue = ccDueDetailsRepo.findById(updateDueDetailsRequest.getCcDueId());
		// The due entry must belong to the card sent in the request
		if(existingDue.isEmpty() || !updateDueDetailsRequest.getCcId().equals(existingDue.get().getCcId())) {
			return "Due details not found.";
		}
		// Partial update: only fields sent in the request are changed
		CcDueDetailsInfo dueDetails = existingDue.get();
		Optional.ofNullable(updateDueDetailsRequest.getDueAmt()).ifPresent(dueDetails::setDueAmt);
		Optional.ofNullable(updateDueDetailsRequest.getMinimumDue()).ifPresent(dueDetails::setMinimumDue);
		Optional.ofNullable(updateDueDetailsRequest.getTotalOutstanding()).ifPresent(dueDetails::setTotalOutstanding);
		Optional.ofNullable(updateDueDetailsRequest.getStatementDate()).ifPresent(dueDetails::setStatementDate);
		Optional.ofNullable(updateDueDetailsRequest.getDueDate()).ifPresent(dueDetails::setDueDate);
		ccDueDetailsRepo.save(dueDetails);
		return "Due details updated successfully.";
	}

	@Override
	public String updateDueStatus(UpdateDueStatusRequest updateDueStatusRequest) {
		if(updateDueStatusRequest.getCcDueId() == null) {
			return "Due details not found.";
		}
		Optional<CcDueDetailsInfo> existingDue = ccDueDetailsRepo.findById(updateDueStatusRequest.getCcDueId());
		if(existingDue.isEmpty()) {
			return "Due details not found.";
		}
		CcDueDetailsInfo dueDetails = existingDue.get();
		dueDetails.setIsPaid(Boolean.TRUE.equals(updateDueStatusRequest.getIsPaid()));
		ccDueDetailsRepo.save(dueDetails);
		return "Due status updated successfully.";
	}

	@Override
	public List<DueDetailsResponse> getDueDetails(Integer ccId) {
		Optional<CreditCardInfo> creditCard = creditCardRepo.findById(ccId);
		if(creditCard.isEmpty()) {
			return Collections.emptyList();
		}
		return ccDueDetailsRepo.findByCcIdOrderByDueDateDesc(ccId).stream()
				.map(dueDetails -> toDueDetailsResponse(dueDetails, creditCard.get()))
				.toList();
	}

	@Override
	public List<DueDetailsResponse> getUserDueDetails(Integer userId) {
		Map<Integer, CreditCardInfo> creditCards = creditCardRepo.findByUserId(userId).stream()
				.collect(Collectors.toMap(CreditCardInfo::getCcId, Function.identity()));
		if(creditCards.isEmpty()) {
			return Collections.emptyList();
		}
		return ccDueDetailsRepo.findByCcIdInOrderByDueDateDesc(new ArrayList<>(creditCards.keySet())).stream()
				.map(dueDetails -> toDueDetailsResponse(dueDetails, creditCards.get(dueDetails.getCcId())))
				.toList();
	}

	private DueDetailsResponse toDueDetailsResponse(CcDueDetailsInfo dueDetails, CreditCardInfo creditCard) {
		DueDetailsResponse response = new DueDetailsResponse();
		response.setCcDueId(dueDetails.getCcDueId());
		response.setCcId(dueDetails.getCcId());
		response.setCcName(creditCard.getCcName());
		response.setCcBank(creditCard.getCcBank());
		response.setCcNumberLast4(lastFourDigits(creditCard.getCcNumber()));
		response.setDueAmt(dueDetails.getDueAmt());
		response.setMinimumDue(dueDetails.getMinimumDue());
		response.setTotalOutstanding(dueDetails.getTotalOutstanding());
		response.setStatementDate(dueDetails.getStatementDate());
		response.setDueDate(dueDetails.getDueDate());
		response.setIsPaid(Boolean.TRUE.equals(dueDetails.getIsPaid()));
		return response;
	}

	// Never expose the full card number; only the last 4 digits
	private String lastFourDigits(String ccNumber) {
		if(ccNumber == null) {
			return null;
		}
		String digits = ccNumber.replaceAll("\\D", "");
		return digits.length() <= 4 ? digits : digits.substring(digits.length() - 4);
	}

}
