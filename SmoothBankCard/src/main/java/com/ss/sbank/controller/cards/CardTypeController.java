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
@RequestMapping("/cardTypes")
public class CardTypeController {
	
	@Autowired
	private CardTypeService ctService;
	
	@GetMapping
	public ResponseEntity<List<CardType>> getAllCardTypes(){
		//For some reason, this isn't being called all of a sudden
		//Think it might be from swapping the class to use RequestMapping as Patrick's suggestion
		//but can't be sure for now.
		System.out.println("Called CT Controller getAll");
		return ctService.getAllCardTypes();
	}
}
