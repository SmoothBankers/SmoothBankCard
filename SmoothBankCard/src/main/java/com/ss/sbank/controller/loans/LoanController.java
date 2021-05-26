package com.ss.sbank.controller.loans;

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

import com.ss.sbank.de.loans.Loan;
import com.ss.sbank.de.loans.LoanType;
import com.ss.sbank.service.loans.LoanService;
import com.ss.sbank.service.loans.LoanTypeService;

@RestController
@CrossOrigin
@RequestMapping("/api/loans")
public class LoanController {

	@Autowired
	private LoanService service;

	@Autowired
	private LoanTypeService ltService;
	
	@GetMapping("/TEST-PLATFORM")
	public List<Loan> getAll(){
		/**
		 * Now normally I wouldn't make this method do anything because it is a major security problem, but for
		 * the sake of demonstrating the program it will remain.
		 * #########REMOVE THIS METHOD ENTIRELY BEFORE DEPLOYING ANYWHERE##############
		 */
		return service.getAllLoans();
	}

	@PostMapping
	public ResponseEntity<?> createLoan(@RequestBody Map<String, Object> payload) {
		System.err.println("Called create loan with payload: " + payload);
		/*
		 * It is admittedly a little interesting that the payload sends everything as
		 * strings despite the data in the forms being locked to numbers, but that's
		 * simply how it is.
		 */
		LoanType lt = ltService.getById(Integer.parseInt((String) payload.get("loanType")));

		if (lt == null) {
			System.err.println("LoanController PostMapping received invalid loanType in payload!");
			return new ResponseEntity<String>("Something went wrong! Please check that all your inputs are valid.",
					HttpStatus.BAD_REQUEST);
		}

		Loan createdLoan = service.createLoan(Integer.parseInt((String) payload.get("accountNumber")), lt,
				(String) payload.get("holderName"));
		return new ResponseEntity<Loan>(createdLoan, HttpStatus.CREATED);
	}

}
