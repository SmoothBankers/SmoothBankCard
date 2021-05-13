package com.ss.utopia.mock;

import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.de.cards.CardType;

public class MockData {

	public static List<CardType> getCardTypeMock(){
		List<CardType> temp = new ArrayList<>();
		CardType tempType = new CardType();
		tempType.setId(1);
		tempType.setRate(0.01);
		tempType.setTitle("Test Card Type");
		tempType.setDescription("This is a test card type, meant only to be used for debugging purposes");
		temp.add(tempType);
		return temp;
		
	}
	
}
