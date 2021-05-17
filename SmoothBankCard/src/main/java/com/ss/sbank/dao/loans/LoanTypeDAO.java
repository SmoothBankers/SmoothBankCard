package com.ss.sbank.dao.loans;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.sbank.de.loans.LoanType;

public interface LoanTypeDAO extends JpaRepository<LoanType, Integer>{

}
