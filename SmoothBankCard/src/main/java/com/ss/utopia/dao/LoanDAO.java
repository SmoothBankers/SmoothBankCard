package com.ss.utopia.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ss.utopia.de.Loan;

/**
 * 
 * @author Parker W.
 *
 */
@Repository
public class LoanDAO extends AbstractDAO<Loan> {
	
	

	@Override
	public List<Loan> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Loan> loans = new ArrayList<>();
		while(rs.next()) {
			Loan tempLoan = new Loan();
			tempLoan.setBalance(rs.getDouble("balance"));
			tempLoan.setDescription(rs.getString("description"));
			tempLoan.setId(rs.getInt("id"));
			tempLoan.setRate(rs.getDouble("rate"));
			tempLoan.setTitle(rs.getString("title"));
			tempLoan.getType().setId(rs.getInt("type"));
			loans.add(tempLoan);
		}
		return loans;
	}

	@Override
	public Integer create(Loan obj) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createNoKey(Loan obj) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Loan read(Object unique_key) throws SQLException, ClassNotFoundException {
		return jdbcTemplate.query("SELECT * FROM loan WHERE id = ?"	, this, (Integer) unique_key).get(0);
	}

	@Override
	public List<Loan> readAll() throws SQLException, ClassNotFoundException {
		return jdbcTemplate.query("SELECT * FROM loan", this);
	}

	@Override
	public void update(Loan replacement) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Loan target) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
