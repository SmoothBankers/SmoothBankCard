package com.ss.sbank.controller.cards;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
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
	public ResponseEntity<CardRecord> getOneCardRecord(@PathVariable Integer id) {
		return new ResponseEntity<CardRecord>(crService.getCardRecord(id), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<CardRecord> updateRecord(@RequestBody CardRecord payload) {

		System.out.println("Update Record with payload: " + payload);
//		CardRecord cr = crService.getCardRecord(Integer.parseInt((String) payload.get("id")));
//		cr.getHolder().setAddress((String) ((Map<String, Object>) payload.get("holder")).get("address"));
//		cr.getHolder().setCellPhone((String) ((Map<String, Object>) payload.get("holder")).get("cellPhone"));
//		cr.getHolder().setEmail((String) ((Map<String, Object>) payload.get("holder")).get("email"));
//		cr.getHolder().setHolderName((String) ((Map<String, Object>) payload.get("holder")).get("holderName"));
//		cr.getHolder().setHomePhone((String) ((Map<String, Object>) payload.get("holder")).get("homePhone"));
//		cr.getHolder().setMonthlyIncome((Integer) ((Map<String, Object>) payload.get("holder")).get("monthlyIncome"));
//		cr.getHolder().setPo_box((String) ((Map<String, Object>) payload.get("holder")).get("po_box"));
//		cr.getHolder().setSsn((String) ((Map<String, Object>) payload.get("holder")).get("ssn"));
//		cr.getHolder().setWorkPhone((String) ((Map<String, Object>) payload.get("holder")).get("workPhone"));
//		cr.getHolder().setZipcode((Integer) ((Map<String, Object>) payload.get("holder")).get("zipcode"));
//		// Update Card
//		cr.getCard().setBalance((Double) ((Map<String, Object>) payload.get("card")).get("balance"));
//		cr.getCard().setCashback((Double) ((Map<String, Object>) payload.get("card")).get("cashback"));
//		cr.getCard().setExpiryMonth((Integer) ((Map<String, Object>) payload.get("card")).get("expiryMonth"));
//		cr.getCard().setExpiryYear((Integer) ((Map<String, Object>) payload.get("card")).get("expirtYear"));
//		cr.getCard().setHolderName((String) ((Map<String, Object>) payload.get("card")).get("holderName"));
		CardRecord updatedRecord = crService.getCardRecord(payload.getId());
		updatedRecord.setCard(payload.getCard());
		updatedRecord.setActive(payload.isActive());
		updatedRecord.setConfirmed(payload.isConfirmed());
		updatedRecord.setHolder(payload.getHolder());
		updatedRecord.setSignUpDate(payload.getSignUpDate());
		// Update Record
//		java.util.Date date;
//		try {
//			date = DateFormat.getDateInstance().parse((String) payload.get("signUpDate"));
//			Date sqlDate = new Date(date.getTime());
//			cr.setSignUpDate(sqlDate);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		cr.setActive((Integer) payload.get("active") != 0);
		// return updated record + HttpStatus.OK

		return new ResponseEntity<CardRecord>(new CardRecord(), HttpStatus.OK);
	}

}
