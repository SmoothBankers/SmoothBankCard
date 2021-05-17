package com.ss.sbank.dao.loans;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.sbank.de.loans.Loan;

public interface LoanDAO extends JpaRepository<Loan, Integer> {

}
