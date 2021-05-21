package com.ss.sbank.service.cards;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ss.sbank.dao.cards.CardTypeDAO;
import com.ss.sbank.de.cards.CardType;

@Service
public class CardTypeService {
	
	@Autowired
	private CardTypeDAO ctDAO;
	
	public ResponseEntity<List<CardType>> getAllCardTypes(){
		System.out.println("Called CT Service getAll");
		List<CardType> types = new ArrayList<>();
		ctDAO.findAll().forEach(types::add);
		ctDAO.findAll().forEach(System.out::println);
		return new ResponseEntity<List<CardType>>(types, HttpStatus.OK);
	}

}
