package com.ss.sbank.controller.cards;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<CardType> getAllCardTypes() {
		System.out.println("CT GET ALL CALLED");
		return ctService.getAllCardTypes();
	}
	
	@GetMapping("/information/{id}")
	public CardType getSingleLoan(@PathVariable("id") int id) {
		return ctService.getById(id);
	}

}
