package com.ss.sbank.de.loans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ss.sbank.de.applicants.Holder;

import lombok.Data;

@Table(name = "LOANRECORD")
@Entity
@Data
public class LoanRecord {
	
	@OneToOne
	@JoinColumn(name = "holder_id")
	private Holder holder;
	
	@OneToOne
	@JoinColumn(name = "loan_id")
	private Loan loan;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

}