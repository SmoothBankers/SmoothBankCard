package com.ss.sbank.controller.cards;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.ss.sbank.dao.cards.CardTypeDAO;
import com.ss.sbank.service.cards.CardTypeService;

@WebMvcTest(controllers = CardTypeController.class)
public class CardTypeControllerTest {

	@MockBean
	private CardTypeService ctService;
	
	@MockBean
	private CardTypeDAO ctDAO;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getAllCardTypesTest() throws Exception{
		mockMvc.perform(get("/api/cardTypes"))
		.andExpect(status().isOk());
	}
	
}
