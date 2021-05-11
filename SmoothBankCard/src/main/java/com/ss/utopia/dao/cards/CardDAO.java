package com.ss.utopia.dao.cards;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.utopia.de.cards.Card;

public interface CardDAO extends JpaRepository<Card, Integer>{

}
