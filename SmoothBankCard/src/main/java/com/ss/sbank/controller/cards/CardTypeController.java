package com.ss.sbank.controller.cards;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.sbank.de.cards.CardType;
import com.ss.sbank.service.cards.CardTypeService;

@RestController
@CrossOrigin
@RequestMapping("/cardTypes")
public class CardTypeController {
	
	@Autowired
	private CardTypeService ctService;
	
	@GetMapping()
	public List<CardType> getAllCardTypes(){
		return ctService.getAllCardTypes();
	}
}
