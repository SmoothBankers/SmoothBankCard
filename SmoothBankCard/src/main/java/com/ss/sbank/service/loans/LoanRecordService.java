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
	
	/**
	 * Takes an email and returns all LoanRecord entries that have
	 * that email assigned to the holder of the loan records.
	 * There are some concerns about the speed of this operation
	 * but, since it is necessary to check every entry, O(n)
	 * should be about as good as it can get, which it currently is.
	 * @param email The email to restrict results to
	 * @return A list of all LoanRecords with the given email
	 */
	public List<LoanRecord> getAllWithEmail(String email){
		List<LoanRecord> records = new ArrayList<>();
		lrDAO.findAll().forEach(record -> {
			if(record.getHolder().getEmail().equals(email))
				records.add(record);
		});
		return records;
	}
	
}
