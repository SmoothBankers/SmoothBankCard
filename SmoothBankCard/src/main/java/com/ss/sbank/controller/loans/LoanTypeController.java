package com.ss.sbank.controller.loans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.sbank.de.loans.LoanType;
import com.ss.sbank.service.loans.LoanTypeService;

@RestController
@CrossOrigin
@RequestMapping("/api/loanTypes")
public class LoanTypeController {

	@Autowired
	private LoanTypeService ltService;

	@GetMapping
	public List<LoanType> getAllLoanTypes() {
		return ltService.getAllLoanTypes();
	}
	
	@GetMapping("/information/{id}")
	public LoanType getSingleLoan(@PathVariable("id") int id) {
//		System.err.println("Called getMapping with id: " + id);
		return ltService.getById(id);
	}

}
