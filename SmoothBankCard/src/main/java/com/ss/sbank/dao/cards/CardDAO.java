package com.ss.sbank.dao.cards;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.sbank.de.cards.Card;

public interface CardDAO extends JpaRepository<Card, Long>{
	/**
	 * Best I can figure, somehow Http Requests are going straight to here.
	 * Deleting the Service and Controller still lets Axios and direct access (via curl or Chrome)
	 * still do GET/POST, which is impressive but inconvenient.
	 */
}
