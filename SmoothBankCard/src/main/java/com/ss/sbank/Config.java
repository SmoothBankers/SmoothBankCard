package com.ss.sbank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ss.sbank.service.MessageService;

@Configuration
public class Config {

	@Bean
	com.ss.sbank.service.MessageService messageService() {
		return new MessageService();
	}
	
}
