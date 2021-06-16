package com.ss.sbank.mail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	
	@Autowired
	TokenDAO tdao;
	
	@Autowired
	JavaMailSender mailSender;
	
	public void sendMessage(Message message) {
		//First, see if the token is in the database already and, if not, save it
		if(tdao.existsById(message.getToken().getSequence())) {
			//Token already exists in the database, do we assume it's been resent and not worry about it?
		} else {
			tdao.saveAndFlush(message.getToken());
		}
		
		//Construct the email
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(message.getAddress());
		email.setSubject(message.getSubject());
		email.setText(message.getBody() + "\n" + message.getLink() + message.getToken().getSequence());
		email.setFrom("noreply@smoothbank.com");
		
		//Prepare the mail sender
		
		System.out.println("*********Attempting to send mail**************");
		try {
			mailSender.send(email);
		} catch(MailException e) {
			System.err.println("Critical mail failure (MessageService line: 38");
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
