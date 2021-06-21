package com.ss.sbank.controller.cards;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.sbank.de.cards.Card;
import com.ss.sbank.de.cards.CardRecord;
import com.ss.sbank.de.holder.Holder;
import com.ss.sbank.mail.Message;
import com.ss.sbank.mail.MessageService;
import com.ss.sbank.mail.Token;
import com.ss.sbank.mail.TokenService;
import com.ss.sbank.service.cards.CardRecordService;
import com.ss.sbank.service.cards.CardService;
import com.ss.sbank.service.cards.CardTypeService;
import com.ss.sbank.service.holder.HolderService;

@RestController
@CrossOrigin
@RequestMapping("/api/cards")
public class CardController {

	@Autowired
	private CardService cService;

	@Autowired
	private CardTypeService ctService;
	
	@Autowired
	private TokenService tService;
	
	@Autowired
	private CardRecordService crService;
	
	@Autowired
	private MessageService messageService;

	@Autowired
	private HolderService hService;
	
	@GetMapping("/TEST-PLATFORM")
	public List<Card> getAll(){
		/**
		 * Now normally I wouldn't make this method do anything because it is a major security problem, but for
		 * the sake of demonstrating the program it will remain.
		 * #########REMOVE THIS METHOD ENTIRELY BEFORE DEPLOYING ANYWHERE##############
		 */
		return cService.getAllCards();
	}

	@SuppressWarnings("unchecked")
	@PostMapping
	public ResponseEntity<CardRecord> createLoan(@RequestBody Map<String, Object> payload) {
		// Process holder
		Holder holder = hService.createHolder((String) payload.get("name"), (String) payload.get("home_phone"),
				(String) payload.get("cell_phone"), (String) payload.get("work_phone"), (String) payload.get("email"),
				(String) payload.get("ssn"), (String) payload.get("address"), (String) payload.get("po_box"),
				Integer.parseInt((String) payload.get("zipcode")),
				Integer.parseInt((String) payload.get("monthly_income")));
		
		// Process card. TODO: This should actually take the users account, but for now use this as a stand-in
		Card c = cService.createCard( new Random().nextInt(), 
				ctService.getById( Integer.parseInt( (String) ((LinkedHashMap<String, Object>) payload.get("card")).get("id") ) ) ,
				holder.getHolderName());

		// Process LoanRecord
		CardRecord cr = crService.createCardRecord(holder, c);
		
		System.out.println("Created loan record: " + cr);
		
		//Generate token, message, email
		Token token = new Token("" + cr.getId());
		Message message = new Message(token, holder.getEmail(), "http://localhost:3000/confirmLoan?token=");
		messageService.sendMessage(message);
		
		//Return response
		return new ResponseEntity<CardRecord>(cr, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<CardRecord> confirmLoan(@RequestBody Map<String, Object> payload){
		Token token = tService.getToken((String) payload.get("token"));	
		//System.out.println(token);
		
		CardRecord cr = crService.getCardRecord(Integer.parseInt(token.getObjID()));
		//System.out.println(lr);
		
		cr.setActive(true); // <==== Causes error for InvalidDefinitionException
		
		crService.update(cr);
		
		return new ResponseEntity<CardRecord>(cr, HttpStatus.CREATED);
	}


}
