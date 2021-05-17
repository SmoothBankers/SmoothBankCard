package com.ss.sbank.dao.cards;

import org.springframework.stereotype.Repository;

import com.ss.sbank.de.cards.CardType;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CardTypeDAO extends JpaRepository<CardType, Integer> {
}