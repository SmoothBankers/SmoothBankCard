package com.ss.sbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SmoothBankCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmoothBankCardApplication.class, args);
	}

}
