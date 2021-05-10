package com.ss.utopia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.utopia.de.Loan;

public interface LoanDAO extends JpaRepository<Loan, Integer> {

}
