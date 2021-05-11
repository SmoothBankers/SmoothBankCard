package com.ss.utopia.dao.loans;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.utopia.de.loans.Loan;

public interface LoanDAO extends JpaRepository<Loan, Integer> {

}
