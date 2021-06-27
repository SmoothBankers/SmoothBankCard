package com.ss.sbank.controller.cards;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		return new ResponseEntity<>(crService.getAllCardRecords(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CardRecord> getOneCardRecord(@PathVariable Integer id){
		return new ResponseEntity<CardRecord>(crService.getCardRecord(id), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<CardRecord> updateRecord(@RequestBody Map<String, Object> payload){
		//TODO: take payload and split into a Holder, Card, and it's own data
		//TODO: figure out why cURL works but the Admin UI http.put does not
		//update Holder
		System.out.println("Update Record with payload: " + payload);
		//CardRecord cr = crService.getCardRecord(Integer.parseInt((String) payload.get("")));
		//Update Card
		//Update Record
		//return updated record + HttpStatus.OK
		
		return new ResponseEntity<CardRecord>(new CardRecord(), HttpStatus.OK);
	}
	

}
