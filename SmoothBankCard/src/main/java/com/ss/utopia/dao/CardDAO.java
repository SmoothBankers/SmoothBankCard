/**
 * 
 */
package com.ss.utopia.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ss.utopia.de.Card;

/**
 * @author Parker W.
 *
 */
@Repository
public class CardDAO extends AbstractDAO<Card> {

	/*
	 * TODO- when a user registers for a card take in the account id from the
	 * current session cookies (or other source from page) use the account id to
	 * create a temporary account variable with the id and use that to connect in
	 * the database/table
	 */

	@Override
	public Integer create(Card obj) throws SQLException, ClassNotFoundException {
		//This shouldn't really be used anywhere, but on the off chance it is simply return the
		//given unique card number or null on a failure.
		return createNoKey(obj) ? obj.getId() : null;
	}

	@Override
	public boolean createNoKey(Card obj) throws SQLException, ClassNotFoundException {
		
		return false;
	}

	@Override
	public Card read(Object unique_key) throws SQLException, ClassNotFoundException {
		return jdbcTemplate.query("SELECT * FROM card WHERE id = ?", this, (Integer) unique_key).get(0);
	}

	@Override
	public List<Card> readAll() throws SQLException, ClassNotFoundException {
		return jdbcTemplate.query("SELECT * FROM card", this);
	}

	@Override
	public void update(Card replacement) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Card target) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Card> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Card> cards = new ArrayList<>();
		while (rs.next()) {
			Card tempCard = new Card();
			// TODO - retrieve account id, dependent on account table
			// tempCard.getAccount().setId(rs.getInt("account_id"));
			tempCard.setActive(rs.getBoolean("active"));
			tempCard.setBalance(rs.getDouble("balance"));
			tempCard.setCashback(rs.getDouble("cashback"));
			tempCard.setCsv(rs.getInt("csv"));
			tempCard.setId(rs.getInt("id"));
			cards.add(tempCard);

		}
		return cards;
	}

}
