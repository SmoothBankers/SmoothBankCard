package com.ss.sbank.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
	
	@Autowired
	TokenDAO tDAO;
	
	public Token getToken(String id) {
		return tDAO.getOne(id);
	}

}
