package com.ss.sbank.controller.cards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.sbank.de.cards.Card;
import com.ss.sbank.de.cards.CardType;
import com.ss.sbank.service.cards.CardService;

@RestController
@CrossOrigin
@RequestMapping("/cards")
public class CardController {
	
	@Autowired
	private CardService service;
	
//	Keep this hidden, we don't want the average user to be able to see all the cards for obvious security reasons
//	@GetMapping()
//	public List<Card> getAllCards(){
//		return service.getAllCards();
//	}
	
	@PostMapping
	public ResponseEntity<?> createCard(@RequestHeader("account-number") Integer accNum, @RequestHeader("card-type") CardType cardType, String holderName){
		Card c = service.createCard(accNum, cardType, holderName);
		if(c == null) {
			return new ResponseEntity<String>("Card Type does not exist", HttpStatus.BAD_REQUEST);
		}		
		return new ResponseEntity<Card>(c, HttpStatus.OK);
	}

}
