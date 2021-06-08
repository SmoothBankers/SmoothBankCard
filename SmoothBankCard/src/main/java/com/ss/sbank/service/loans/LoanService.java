package com.ss.sbank.service.loans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.sbank.dao.loans.LoanDAO;
import com.ss.sbank.dao.loans.LoanTypeDAO;
import com.ss.sbank.de.loans.Loan;
import com.ss.sbank.de.loans.LoanType;

@Service
public class LoanService {

	@Autowired
	LoanDAO lDAO;
	
	@Autowired
	LoanTypeDAO ltDAO;

	public List<Loan> getAllLoans() {
		List<Loan> loans = new ArrayList<>();
		lDAO.findAll().forEach(loans::add);
		return loans;
	}

	public Loan createLoan(Double balance, String holder, LoanType type) {
		Loan l = new Loan();
		l.setBalance(balance);
		l.setHolderName(holder);
		l.setType(type);
		
		return lDAO.saveAndFlush(l);
	}
}
