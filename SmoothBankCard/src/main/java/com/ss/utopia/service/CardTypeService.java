package com.ss.utopia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.utopia.dao.CardTypeDAO;
import com.ss.utopia.de.CardType;

@Service
public class CardTypeService {
	
	@Autowired
	private CardTypeDAO ctDAO;
	
	public List<CardType> getAllCardTypes(){
		List<CardType> types = new ArrayList<>();
		ctDAO.findAll().forEach(types::add);
		return types;
	}

}
