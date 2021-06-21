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
import org.springframework.web.bind.annotation.PutMapping;
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
import com.ss.sbank.mail.TokenService;
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
	
	@Autowired
	private TokenService tService;

	@GetMapping("/LOAN-TEST-PLATFORM")
	public List<Loan> getAll() {
		return lservice.getAllLoans();
	}

	@SuppressWarnings("unchecked")
	@PostMapping
	public ResponseEntity<LoanRecord> createLoan(@RequestBody Map<String, Object> payload) {
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
		Message message = new Message(token, holder.getEmail(), "http://localhost:3000/confirmLoan?token=");
		messageService.sendMessage(message);
		
		//Return response
		return new ResponseEntity<LoanRecord>(lr, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<LoanRecord> confirmLoan(@RequestBody Map<String, Object> payload){
		Token token = tService.getToken((String) payload.get("token"));	
		//System.out.println(token);
		
		LoanRecord lr = lrService.getLoanRecord(Integer.parseInt(token.getObjID()));
		//System.out.println(lr);
		
		lr.setActive(true); // <==== Causes error for InvalidDefinitionException
		
		lrService.update(lr);
		
		return new ResponseEntity<LoanRecord>(lr, HttpStatus.CREATED);
	}

}
