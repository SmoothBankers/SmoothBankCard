package com.ss.sbank.mail;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenDAO extends JpaRepository<Token, String>{

}
