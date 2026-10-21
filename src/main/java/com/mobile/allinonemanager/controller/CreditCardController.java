package com.mobile.allinonemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.allinonemanager.entity.CreditCardInfo;
import com.mobile.allinonemanager.request.dto.AddCreditCardRequest;
import com.mobile.allinonemanager.request.dto.AddDueDetailsRequest;
import com.mobile.allinonemanager.request.dto.UpdateCreditCardRequest;
import com.mobile.allinonemanager.response.dto.DueDetailsResponse;
import com.mobile.allinonemanager.service.CreditCardService;

@RestController
@RequestMapping("/credit-cards")
public class CreditCardController {

	@Autowired
	private CreditCardService creditCardService;

	@GetMapping("/{userId}")
	public ResponseEntity<?> getCreditCards(@PathVariable Integer userId) {
		List<CreditCardInfo> response = creditCardService.getCreditCards(userId);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/add")
	public ResponseEntity<?> addCreditCard(@RequestBody AddCreditCardRequest addCreditCardRequest) {
		String response = creditCardService.addCreditCard(addCreditCardRequest);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateCreditCard(@RequestBody UpdateCreditCardRequest updateCreditCardRequest) {
		String response = creditCardService.updateCreditCard(updateCreditCardRequest);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/due/add")
	public ResponseEntity<?> addDueDetails(@RequestBody AddDueDetailsRequest addDueDetailsRequest) {
		String response = creditCardService.addDueDetails(addDueDetailsRequest);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/due/{ccId}")
	public ResponseEntity<?> getDueDetails(@PathVariable Integer ccId) {
		List<DueDetailsResponse> response = creditCardService.getDueDetails(ccId);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/due/user/{userId}")
	public ResponseEntity<?> getUserDueDetails(@PathVariable Integer userId) {
		List<DueDetailsResponse> response = creditCardService.getUserDueDetails(userId);
		return ResponseEntity.ok(response);
	}

}
