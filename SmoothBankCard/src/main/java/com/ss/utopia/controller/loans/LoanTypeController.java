package com.ss.utopia.controller.loans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.utopia.de.loans.LoanType;
import com.ss.utopia.service.loans.LoanTypeService;

@RestController
public class LoanTypeController {

	@Autowired
	private LoanTypeService ltService;

	@RequestMapping("/loanTypes")
	public List<LoanType> getAllCardTypes() {
		return ltService.getAllLoanTypes();
	}

}
