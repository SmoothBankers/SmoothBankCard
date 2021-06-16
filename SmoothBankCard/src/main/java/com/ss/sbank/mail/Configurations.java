package com.ss.sbank.mail;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class Configurations {
	
	@Bean(name="mailSender")
	JavaMailSender javaMailService() {
		
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		
		javaMailSender.setHost("smtp.gmail.com");
		javaMailSender.setPort(587);
		javaMailSender.setProtocol("smtp");
		/************IMPORTANT***************************/
		/*
		 *This is fairly sensitive information and should handled as such 
		 */
		javaMailSender.setUsername("smoothbank.mailing@gmail.com");
		javaMailSender.setPassword("GsN@=F7kFh5guuk^");
		
		
		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.auth",  "true");
		mailProperties.put("mail.smtp.starttls.enable", "true");
		mailProperties.put("mail.smtp.debug", "true");
		javaMailSender.setJavaMailProperties(mailProperties);
		return javaMailSender;
	}

}
