package com.ss.sbank.dao.cards;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.sbank.de.cards.Card;

public interface CardDAO extends JpaRepository<Card, Integer>{

}
