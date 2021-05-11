package com.ss.utopia.controller.loans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.utopia.de.loans.Loan;
import com.ss.utopia.service.loans.LoanService;

@RestController
public class LoanController {
	
	@Autowired
	private LoanService service;
	
	@RequestMapping("/loans")
	public List<Loan> getAllLoans(){
		return service.getAllLoans();
	}

}
