package com.ss.sbank.dao.loans;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.sbank.de.loans.LoanRecord;

public interface LoanRecordDAO extends JpaRepository<LoanRecord, Integer> {

}
