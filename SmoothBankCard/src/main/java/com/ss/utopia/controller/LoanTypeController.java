package com.ss.utopia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.utopia.de.LoanType;
import com.ss.utopia.service.LoanTypeService;

@RestController
public class LoanTypeController {

	@Autowired
	private LoanTypeService ltService;

	@RequestMapping("/loanTypes")
	public List<LoanType> getAllCardTypes() {
		return ltService.getAllLoanTypes();
	}

}
