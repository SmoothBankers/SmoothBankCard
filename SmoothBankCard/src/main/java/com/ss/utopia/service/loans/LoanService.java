package com.ss.utopia.service.loans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.utopia.dao.loans.LoanDAO;
import com.ss.utopia.de.loans.Loan;

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
