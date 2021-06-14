package com.ss.sbank.controller.loans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.sbank.de.loans.LoanRecord;
import com.ss.sbank.service.loans.LoanRecordService;

@RestController
@CrossOrigin
@RequestMapping("/api/loanRecords")
public class LoanRecordController {
	
	/**
	 * IMPORTANT NOTICE: This controller only exists for testing purposes and should needs to
	 * be restricted to admin accounts in the future as it is not safe as it currently exists
	 */
	
	@Autowired
	LoanRecordService lrService;
	
	@GetMapping
	public List<LoanRecord> getAllLoanTypes() {
		return lrService.getAllLoanRecords();
	}

}
