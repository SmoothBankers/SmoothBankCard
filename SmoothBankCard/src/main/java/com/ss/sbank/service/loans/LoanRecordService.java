package com.ss.sbank.service.loans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.sbank.dao.loans.LoanRecordDAO;
import com.ss.sbank.de.holder.Holder;
import com.ss.sbank.de.loans.Loan;
import com.ss.sbank.de.loans.LoanRecord;

@Service
public class LoanRecordService {

	@Autowired
	LoanRecordDAO lrDAO;
	
	public LoanRecord createLoanRecord(Holder holder, Loan loan) {
		LoanRecord record = new LoanRecord();
		record.setHolder(holder);
		record.setLoan(loan);
		return lrDAO.saveAndFlush(record);
		
		
	}
	
	public List<LoanRecord> getAllLoanRecords(){
		List<LoanRecord> records = new ArrayList<>();
		lrDAO.findAll().forEach(records::add);
		return records;
	}
	
	public LoanRecord getLoanRecord(Integer id) {
		return lrDAO.getOne(id);
	}
	
	public void update(LoanRecord lr) {
		lrDAO.saveAndFlush(lr);
	}
	
}
