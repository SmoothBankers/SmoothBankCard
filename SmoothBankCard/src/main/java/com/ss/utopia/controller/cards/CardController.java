package com.ss.utopia.controller.cards;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.utopia.de.cards.Card;
import com.ss.utopia.service.cards.CardService;

@RestController
public class CardController {
	
	@Autowired
	private CardService service;
	
	@RequestMapping("/cards")
	public List<Card> getAllCards(){
		return service.getAllCards();
	}

}
