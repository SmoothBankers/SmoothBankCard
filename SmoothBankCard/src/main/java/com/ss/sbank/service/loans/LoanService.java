package com.ss.sbank.service.loans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.sbank.dao.loans.LoanDAO;
import com.ss.sbank.de.loans.Loan;
import com.ss.sbank.de.loans.LoanType;

@Service
public class LoanService {

	@Autowired
	LoanDAO lDAO;

	public List<Loan> getAllLoans() {
		List<Loan> loans = new ArrayList<>();
		lDAO.findAll().forEach(loans::add);
		return loans;
	}

	/**
	 * Card creation occurs here and so the generation of the code and csv should
	 * occur here.
	 * 
	 * [MII][IIN][Account][Check digit]
	 * 
	 * [Check Digit] -> Luhn Algorithm Validation -> Double every second digit
	 * starting from the right-most check digit, sum all individual digits (12 turns
	 * to 3), valid if sum % 10 == 0 Calculation -> check digit = ( sum * 9 ) % 10
	 */

	public Loan createLoan(int accountNumber, LoanType type, String holderName) {
		// Error checking
		if (type == null) {
			return null;
		}

		Loan l = new Loan();
		Long id = 4321000000000000l;
		id += accountNumber;
		// calculate check digit
		int sum = 0;
		Long workingId = id;
		for (int i = 0; i < 12; i++) {
			sum += workingId % 10;
			workingId /= 10;
		}

		id *= 10;
		id += ((sum * 9) % 10);
		l.setId(id);

		// if card already exists
		if (lDAO.existsById(l.getId())) {
			/**
			 * Return null so that the controller recognizes that there is a problem. Don't
			 * want to create duplicates as that is a conflict for the database.
			 */
			return null;
		}

		l.setHolderName(holderName);
		l.setBalance(0.00);
		
		lDAO.saveAndFlush(l);
		return l;
	}
}
