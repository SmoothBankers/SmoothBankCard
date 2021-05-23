package com.ss.sbank.controller.cards;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.sbank.de.cards.CardType;
import com.ss.sbank.service.cards.CardTypeService;

@RestController
@CrossOrigin
@RequestMapping("/api/cardTypes")
public class CardTypeController {
	
	@Autowired
	private CardTypeService ctService;
	
	@GetMapping
	public ResponseEntity<List<CardType>> getAllCardTypes(){
		System.out.println("Called CT Controller getAll");
		return ctService.getAllCardTypes();
	}
}
