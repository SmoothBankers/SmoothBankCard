package com.ss.sbank.dao.cards;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.sbank.de.cards.CardRecord;

public interface CardRecordDAO extends JpaRepository<CardRecord, Integer>{

}
