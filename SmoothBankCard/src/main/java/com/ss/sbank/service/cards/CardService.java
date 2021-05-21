package com.ss.sbank.service.cards;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.sbank.dao.cards.CardDAO;
import com.ss.sbank.de.cards.Card;
import com.ss.sbank.de.cards.CardType;

@Service
public class CardService {

	@Autowired
	CardDAO cDAO;

	public List<Card> getAllCards() {
		List<Card> cards = new ArrayList<>();
		cDAO.findAll().forEach(cards::add);
		return cards;
	}

	/**
	 * Card creation occurs here and so the generation of the code and csv should
	 * occur here.
	 * 
	 * [MII][IIN][Account][Check digit]
	 * 
	 * [Check Digit] -> Luhn Algorithm Validation -> Double every second digit
	 * starting from the right-most check digit, sum all individual digits (12 turns
	 * to 3), valid if sum % 10 == 0 Calculation -> check digit = ( sum * 9 ) % 10
	 */

	public Card createCard(int accountNumber, CardType type, String holderName) {
		System.out.println("Account Number: " + accountNumber + "; CardType: " + type);

		// Error checking
		if (type == null) {
			return null;
		}

		Card c = new Card();
		Long id = 4321000000000000l;
		id += accountNumber;
		// calculate check digit
		int sum = 0;
		Long workingId = id;
		for (int i = 0; i < 12; i++) {
			sum += workingId % 10;
			workingId /= 10;
		}

		id *= 10;
		id += ((sum * 9) % 10);
		c.setId(id);

		// if card already exists
		if (cDAO.existsById(c.getId())) {
			return cDAO.getOne(c.getId());
		}

		int csvNum = new Random().nextInt(1000); // for security reasons, make the csv random
		c.setCsv(csvNum);
		Calendar currCal = new GregorianCalendar();
		c.setExpiryMonth((currCal.get(Calendar.MONTH) + 6) % 12); // expires 30 months, or 2.5 years, after creation
		c.setExpiryYear(currCal.get(Calendar.YEAR) + 2);
		c.setType(type);
		c.setHolderName(holderName);
		return c;
	}
}
