package com.ss.utopia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.utopia.dao.LoanTypeDAO;
import com.ss.utopia.de.LoanType;

@Service
public class LoanTypeService {

	@Autowired
	private LoanTypeDAO ltDAO;

	public List<LoanType> getAllLoanTypes() {
		List<LoanType> types = new ArrayList<>();
		ltDAO.findAll().forEach(types::add);
		return types;
	}
}
