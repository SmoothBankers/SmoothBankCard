package com.ss.utopia.controller.cards;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.utopia.de.cards.CardType;
import com.ss.utopia.service.cards.CardTypeService;

@RestController
public class CardTypeController {
	
	@Autowired
	private CardTypeService ctService;
	
	@RequestMapping("/cardTypes")
	public List<CardType> getAllCardTypes(){
		return ctService.getAllCardTypes();
	}

}
