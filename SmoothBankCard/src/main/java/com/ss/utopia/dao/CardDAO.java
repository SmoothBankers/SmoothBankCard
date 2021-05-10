package com.ss.utopia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.utopia.de.Card;

public interface CardDAO  extends JpaRepository<Card, Integer>{

}
