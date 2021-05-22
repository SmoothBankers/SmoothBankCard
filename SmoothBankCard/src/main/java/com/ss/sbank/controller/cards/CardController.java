package com.ss.sbank.controller.cards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.sbank.service.cards.CardService;

@RestController
@CrossOrigin
@RequestMapping("/cards")
public class CardController {
	
//	@Autowired
//	private CardService service;
	
//	@PostMapping
//	public ResponseEntity<?> createCard(){
//		System.out.println("Called create card");
//		return new ResponseEntity<String>("Called PostMapping in CardController", HttpStatus.ACCEPTED);	
//	}


}
