package com.ss.utopia.dao.cards;

import org.springframework.stereotype.Repository;

import com.ss.utopia.de.cards.CardType;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CardTypeDAO extends JpaRepository<CardType, Integer> {
}