package com.ss.utopia.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.utopia.de.CardType;

@Repository
public interface CardTypeDAO extends JpaRepository<CardType, Integer> {
}