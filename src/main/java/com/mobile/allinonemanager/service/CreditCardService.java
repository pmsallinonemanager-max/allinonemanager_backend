package com.mobile.allinonemanager.service;

import java.util.List;

import com.mobile.allinonemanager.entity.CreditCardInfo;
import com.mobile.allinonemanager.request.dto.AddCreditCardRequest;
import com.mobile.allinonemanager.request.dto.AddDueDetailsRequest;
import com.mobile.allinonemanager.request.dto.UpdateCreditCardRequest;
import com.mobile.allinonemanager.request.dto.UpdateCreditCardStatusRequest;
import com.mobile.allinonemanager.request.dto.UpdateDueDetailsRequest;
import com.mobile.allinonemanager.request.dto.UpdateDueStatusRequest;
import com.mobile.allinonemanager.response.dto.DueDetailsResponse;

public interface CreditCardService {

	List<CreditCardInfo> getCreditCards(Integer userId);

	String addCreditCard(AddCreditCardRequest addCreditCardRequest);

	String updateCreditCard(UpdateCreditCardRequest updateCreditCardRequest);

	String updateCreditCardStatus(UpdateCreditCardStatusRequest updateCreditCardStatusRequest);

	String deleteCreditCard(Integer ccId);

	String addDueDetails(AddDueDetailsRequest addDueDetailsRequest);

	String updateDueDetails(UpdateDueDetailsRequest updateDueDetailsRequest);

	String updateDueStatus(UpdateDueStatusRequest updateDueStatusRequest);

	String deleteDueDetails(Integer ccDueId, Integer ccId);

	List<DueDetailsResponse> getDueDetails(Integer ccId);

	List<DueDetailsResponse> getUserDueDetails(Integer userId);

}
