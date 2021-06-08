package com.ss.sbank.service.holder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.sbank.dao.holder.HolderDAO;
import com.ss.sbank.de.holder.Holder;

@Service
public class HolderService {

	@Autowired
	HolderDAO hdao;

	public Holder createHolder(String name, String home, String cell, String work, String email, String ssn,
			String address, String po, Integer zipcode, Integer income) {

		Holder holder = new Holder();
		holder.setHolderName(name);
		holder.setHomePhone(home);
		holder.setCellPhone(cell);
		holder.setWorkPhone(work);
		holder.setEmail(email);
		holder.setSsn(ssn);
		holder.setAddress(address);
		holder.setPo_box(po);
		holder.setZipcode(zipcode);
		holder.setMonthlyIncome(income);
		return hdao.saveAndFlush(holder);
		
	}

}
