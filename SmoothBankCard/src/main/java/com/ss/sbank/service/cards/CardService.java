package com.ss.sbank.service.cards;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.sbank.dao.cards.CardDAO;
import com.ss.sbank.de.cards.Card;

@Service
public class CardService {
	
	@Autowired
	CardDAO cDAO;
	
	public List<Card> getAllCards(){
		List<Card> cards = new ArrayList<>();
		cDAO.findAll().forEach(cards::add);
		return cards;
	}
	
	/**
	 * Card creation occurs here and so the generation of the code and csv should occur here.
	 * 
	 * [MII][IIN][Account][Check digit]
	 * 
	 * [Check Digit] -> Luhn Algorithm
	 * 	Validation -> Double every second digit starting from the right-most check digit, sum all individual digits (12 turns to 3), valid if sum % 10 == 0
	 *  Calculation -> check digit = ( sum * 9 ) % 10
	 */
	
//	public Card createCard(/*Account a*/) {
//		//TODO: import SmoothBankAccount library
//		//int accNum = u.getId();
//		Long cardNum = (long) 4321;
//		cardNum *= ((long) 1000000000000);	//add 12 spaces for account number
//		
//	}
}
