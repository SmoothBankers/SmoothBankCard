package com.ss.sbank.controller.loans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.sbank.de.loans.Loan;
import com.ss.sbank.service.loans.LoanService;

@RestController
@CrossOrigin
@RequestMapping("/api/loans")
public class LoanController {
	
	@Autowired
	private LoanService service;
	
	@GetMapping()
	public List<Loan> getAllLoans(){
		return service.getAllLoans();
	}

}
