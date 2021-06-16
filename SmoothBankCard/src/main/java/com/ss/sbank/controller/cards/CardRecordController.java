package com.ss.sbank.controller.cards;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.sbank.de.cards.CardRecord;
import com.ss.sbank.service.cards.CardRecordService;

@RestController
@CrossOrigin
@RequestMapping("/api/cardRecords")
public class CardRecordController {
	
	@Autowired
	CardRecordService crService;
	
	@GetMapping
	public ResponseEntity<List<CardRecord>> getAllCardRecords() {
		System.out.println("called get all card records");
		return new ResponseEntity<>(crService.getAllCardRecords(), HttpStatus.OK);
	}

}
