package com.ss.sbank.controller.cards;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.sbank.de.cards.Card;
import com.ss.sbank.de.cards.CardType;
import com.ss.sbank.service.cards.CardService;
import com.ss.sbank.service.cards.CardTypeService;

@RestController
@CrossOrigin
@RequestMapping("/api/cards")
public class CardController {

	@Autowired
	private CardService service;

	@Autowired
	private CardTypeService ctService;
	
	@GetMapping("/TEST-PLATFORM")
	public List<Card> getAll(){
		/**
		 * Now normally I wouldn't make this method do anything because it is a major security problem, but for
		 * the sake of demonstrating the program it will remain.
		 * #########REMOVE THIS METHOD ENTIRELY BEFORE DEPLOYING ANYWHERE##############
		 */
		return service.getAllCards();
	}

	@PostMapping()
	public ResponseEntity<?> createCard(@RequestBody Map<String, Object> payload) {
//		System.out.println("Called create card with payload: " + payload);
		/*
		 * It is admittedly a little interesting that the payload sends everything as
		 * strings despite the data in the forms being locked to numbers, but that's
		 * simply how it is.
		 */
		CardType ct = ctService.getById(Integer.parseInt((String) payload.get("cardType")));

		if (ct == null) {
			System.err.println("CardController PostMapping received invalid cardType in payload!");
			return new ResponseEntity<String>("Something went wrong! Please check that all your inputs are valid.",
					HttpStatus.BAD_REQUEST);
		}

		Card createdCard = service.createCard(Integer.parseInt((String) payload.get("accountNumber")), ct,
				(String) payload.get("holderName"));
		return new ResponseEntity<Card>(createdCard, HttpStatus.CREATED);
	}

}
