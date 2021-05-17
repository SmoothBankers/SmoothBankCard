package com.ss.sbank.service.loans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.sbank.dao.loans.LoanDAO;
import com.ss.sbank.de.loans.Loan;

@Service
public class LoanService {
	
	@Autowired
	LoanDAO lDAO;
	
	public List<Loan> getAllLoans(){
		List<Loan> loans = new ArrayList<>();
		lDAO.findAll().forEach(loans::add);
		return loans;
	}

}
