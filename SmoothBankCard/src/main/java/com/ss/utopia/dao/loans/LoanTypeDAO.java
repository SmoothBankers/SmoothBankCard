package com.ss.utopia.dao.loans;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.utopia.de.loans.LoanType;

public interface LoanTypeDAO extends JpaRepository<LoanType, Integer>{

}
