package com.ss.sbank.mail;

import lombok.Data;

@Data
public class Message {

	Token token;
	String address;
	String link;
	String subject = "Smoothbank Confirmation";
	String body = "Thank you for your interest in our service! Please click the following link to continue the process.";

	/**
	 * Generates a message object
	 * @param token the token to include in the message and url
	 * @param recipient the recipient of the message
	 * @param urlLink the specific link for the message to give the recipient
	 */
	public Message(Token token, String recipient, String urlLink) {
		this.setToken(token);
		this.setAddress(recipient);
		this.setLink(urlLink);
	}

}
