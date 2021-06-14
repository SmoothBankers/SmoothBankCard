package com.ss.sbank.controller.loans;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.sbank.de.holder.Holder;
import com.ss.sbank.de.loans.Loan;
import com.ss.sbank.de.loans.LoanRecord;
import com.ss.sbank.service.holder.HolderService;
import com.ss.sbank.service.loans.LoanRecordService;
import com.ss.sbank.service.loans.LoanService;
import com.ss.sbank.service.loans.LoanTypeService;
import com.ss.sbank.mail.Message;
import com.ss.sbank.mail.Token;
import com.ss.sbank.mail.MessageService;

@RestController
@CrossOrigin
@RequestMapping("/api/loans")
public class LoanController {

	@Autowired
	private LoanService lservice;

	@Autowired
	private LoanTypeService ltService;

	@Autowired
	private HolderService hService;

	@Autowired
	private LoanRecordService lrService;
	
	@Autowired
	private MessageService messageService;

	@GetMapping("/TEST-PLATFORM")
	public List<Loan> getAll() {
		/**
		 * Now normally I wouldn't make this method do anything because it is a major
		 * security problem, but for the sake of demonstrating the program it will
		 * remain. #########REMOVE THIS METHOD ENTIRELY BEFORE DEPLOYING
		 * ANYWHERE##############
		 */
		return lservice.getAllLoans();
	}

	@SuppressWarnings("unchecked")
	@PostMapping
	public ResponseEntity<?> createLoan(@RequestBody Map<String, Object> payload) {
		// System.out.println("Called create loan with payload: " + payload);
		/**
		 * TODO: get the loan information from the payload | payload.get("param_name") |
		 * create a Holder object using the information from the payload create a
		 * loanRecord using the loan and the newly-made holder send a confirmation email
		 * with the confirmation link to the given email
		 */
		/**
		 * Example payload {name=Parker Williams, home_phone=1234567,
		 * cell_phone=7654321, work_phone=1762543,
		 * email=parker.williams@smoothstack.com, ssn=0123456789, address=Home Address,
		 * po_box=P.O Box, zipcode=27106, monthly_income=750, amount_requested=1250}
		 */
		// Process holder
		Holder holder = hService.createHolder((String) payload.get("name"), (String) payload.get("home_phone"),
				(String) payload.get("cell_phone"), (String) payload.get("work_phone"), (String) payload.get("email"),
				(String) payload.get("ssn"), (String) payload.get("address"), (String) payload.get("po_box"),
				Integer.parseInt((String) payload.get("zipcode")),
				Integer.parseInt((String) payload.get("monthly_income")));
		
		// Process Loan
		Loan l = lservice.createLoan(Double.parseDouble((String) payload.get("amount_requested")), (String) payload.get("name"), ltService.getById( (Integer) ((LinkedHashMap<String, Object>) payload.get("loan")).get("id")));

		// Process LoanRecord
		LoanRecord lr = lrService.createLoanRecord(holder, l);
		
		System.out.println("Created loan record: " + lr);
		
		//Generate token, message, email
		Token token = new Token("" + lr.getId());
		Message message = new Message(token, holder.getEmail(), "http://localhost:8082/confirmLoan?token=");
		messageService.sendMessage(message);
		
		//Return response
		return new ResponseEntity<LoanRecord>(lr, HttpStatus.CREATED);
	}

}
