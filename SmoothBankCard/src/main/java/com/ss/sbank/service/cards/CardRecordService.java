package com.ss.sbank.service.cards;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.sbank.dao.cards.CardRecordDAO;
import com.ss.sbank.de.cards.Card;
import com.ss.sbank.de.cards.CardRecord;
import com.ss.sbank.de.holder.Holder;

@Service
public class CardRecordService {

	@Autowired
	CardRecordDAO crDAO;
	
	public CardRecord createLoanRecord(Holder holder, Card card) {
		CardRecord record = new CardRecord();
		record.setHolder(holder);
		record.setLoan(card);
		return crDAO.saveAndFlush(record);
		
		
	}
	
	public List<CardRecord> getAllLoanRecords(){
		List<CardRecord> records = new ArrayList<>();
		crDAO.findAll().forEach(records::add);
		return records;
	}
	
}
