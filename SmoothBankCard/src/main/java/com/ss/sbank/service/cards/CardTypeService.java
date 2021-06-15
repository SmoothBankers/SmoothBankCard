package com.ss.sbank.service.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.sbank.dao.cards.CardTypeDAO;
import com.ss.sbank.de.cards.CardType;

@Service
public class CardTypeService {
	
	@Autowired
	private CardTypeDAO ctDAO;
	
	public List<CardType> getAllCardTypes(){
		List<CardType> types = new ArrayList<>();
		ctDAO.findAll().forEach(types::add);
		return types;
	}
	
	public CardType getById(Integer id) {
		Optional<CardType> result = ctDAO.findById(id);
		if(result.isEmpty())
			return null;
		return result.get();
	}

}
