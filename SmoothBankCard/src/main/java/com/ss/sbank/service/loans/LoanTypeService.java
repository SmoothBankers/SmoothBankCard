package com.ss.sbank.service.loans;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.sbank.dao.loans.LoanTypeDAO;
import com.ss.sbank.de.loans.LoanType;

@Service
public class LoanTypeService {

	@Autowired
	private LoanTypeDAO ltDAO;

	public List<LoanType> getAllLoanTypes() {
		System.out.println("Called LT Service getAll");
		List<LoanType> types = new ArrayList<>();
		ltDAO.findAll().forEach(types::add);
		ltDAO.findAll().forEach(System.out::print);
		return types;
	}
	
	public LoanType getById(Integer id) {
		Optional<LoanType> result = ltDAO.findById(id);
		if(result.isEmpty())
			return null;
		return result.get();
	}
}
