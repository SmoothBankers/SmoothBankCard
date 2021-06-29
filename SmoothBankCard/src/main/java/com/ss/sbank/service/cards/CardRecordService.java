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

	public CardRecord createCardRecord(Holder holder, Card card) {
		CardRecord record = new CardRecord();
		record.setHolder(holder);
		record.setCard(card);
		return crDAO.saveAndFlush(record);

	}

	public List<CardRecord> getAllCardRecords() {
		List<CardRecord> records = new ArrayList<>();
		crDAO.findAll().forEach(records::add);
		return records;
	}

	public CardRecord getCardRecord(int parseInt) {
		return crDAO.getOne(parseInt);
	}

	public void update(CardRecord cr) {
		crDAO.save(cr);
	}

	/**
	 * Takes an email and returns all LoanRecord entries that have that email
	 * assigned to the holder of the loan records. There are some concerns about the
	 * speed of this operation but, since it is necessary to check every entry, O(n)
	 * should be about as good as it can get, which it currently is.
	 * 
	 * @param email The email to restrict results to
	 * @return A list of all LoanRecords with the given email
	 */
	public List<CardRecord> getAllWithEmail(String email) {
		List<CardRecord> records = new ArrayList<>();
		crDAO.findAll().forEach(record -> {
			if (record.getHolder().getEmail().equals(email))
				records.add(record);
		});
		return records;
	}

}
