package com.ss.sbank.controller.cards;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.sbank.de.cards.Card;
import com.ss.sbank.service.cards.CardService;

@RestController
@CrossOrigin
@RequestMapping("/cards")
public class CardController {
	
	@Autowired
	private CardService service;
	
	@GetMapping()
	public List<Card> getAllCards(){
		return service.getAllCards();
	}

}
