package com.ss.sbank.mail;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class Configurations {
	
	@Bean(name="mailSender")
	MailSender javaMailService() {
		
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		
		javaMailSender.setHost("smtp.gmail.com");
		javaMailSender.setPort(587);
		javaMailSender.setProtocol("smtp");
		/************IMPORTANT***************************/
		/**This is for testing purposes only! This is to be replaced with a new account
		 * that exists for the sole purpose of sending mail and receiving test mail
		 * REMOVE THIS DATA BEFORE ANY UPLOAD TO ANYWHERE, INCLUDING GITHUB**/
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
