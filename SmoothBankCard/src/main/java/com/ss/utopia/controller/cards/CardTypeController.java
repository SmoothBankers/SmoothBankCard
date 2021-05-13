package com.ss.utopia.controller.cards;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ss.utopia.de.cards.CardType;
import com.ss.utopia.mock.MockData;
import com.ss.utopia.service.cards.CardTypeService;

@RestController
@CrossOrigin
public class CardTypeController {
	
	@Autowired
	private CardTypeService ctService;
	
	@GetMapping("/cardTypes/getAll")
	@CrossOrigin
	public List<CardType> getAllCardTypes(){
//		return ctService.getAllCardTypes();
		//Temporary test just to ensure that data is being sent
		return MockData.getCardTypeMock();
	}
	
	@RequestMapping(path = "/api/cardTypes/testReactConnection", method = RequestMethod.GET)
	@CrossOrigin
	public String presentTestResults() {
		return "Test Passed Successfully";
	}

}
