package com.ss.sbank.mail;

import java.util.Calendar;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "token")
public class Token {

	/**
	 * The Id of the object to create a token for. Uses object to provide
	 * flexibility, but it falls on the caller to remember what the actual type of
	 * the object is.
	 */
	private String objID;
	/**
	 * String representation of the token Generation must be handled
	 */
	@Id
	private String sequence;
	// Time the token was created
	private Calendar created;
	// Time To Live
	private Integer ttl;

	/**
	 * Determines if the Token is still valid by seeing if it's still alive or not
	 * 
	 * @return True if the time passed since creation is less than the time to live
	 */
	public boolean isAlive() {
		return created.getTime().getTime() - Calendar.getInstance().getTime().getTime() <= ttl;
	}

	public void generateSequence() {
		this.setSequence(UUID.randomUUID().toString());
	}

	/**
	 * Generates a Token using a given String representation of a payload. This
	 * String is what will be used for tracking the object, so make sure it's
	 * something the caller can make use of. One example might be the ID of the
	 * object as it is seen in the database. Make sure to remember that it is stored
	 * as a string, so if the ID is actually, for example, an Integer, you will need
	 * to parse it.
	 * 
	 * @param obj The identifying String representation of the object to create the
	 *            token for/
	 */
	public Token(String obj) {
		if(obj.length() > 127) {
			throw new IllegalArgumentException("Token object string length can not excede 127 characters! (Token constructor error)");
		}
		generateSequence();
		this.setObjID(obj);
		this.setTtl(ttl);
	}
	
	public Token() {
		//default constructor for POJO
	}

}
