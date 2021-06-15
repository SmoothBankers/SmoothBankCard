package com.ss.sbank.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	
	@Autowired
	TokenDAO tdao;
	
	@Autowired
	MailSender mailSender;
	
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
		email.setText(message.getBody() + "/n" + message.getLink() + message.getToken().getSequence());
		
		//Prepare the mail sender
		
		
		mailSender.send(email);
		
		
		
		
		
	}

}
