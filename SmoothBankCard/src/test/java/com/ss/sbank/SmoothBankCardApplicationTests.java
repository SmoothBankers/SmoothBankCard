package com.ss.sbank;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ss.sbank.controller.cards.CardTypeController;
import com.ss.sbank.controller.loans.LoanTypeController;

@SpringBootTest
class SmoothBankCardApplicationTests {
	
	@Autowired
	CardTypeController ctController;
	
	@Autowired
	LoanTypeController ltController;

	@Test
	void contextLoads() {
		assertThat(ctController).isNotNull();
		assertThat(ltController).isNotNull();
	}

}
