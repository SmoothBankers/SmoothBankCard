package com.ss.sbank.de.loans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="loan")
@Getter
@Setter
public class Loan {

	@Id
	@GenericGenerator(name = "loan_id", strategy = "com.ss.sbank.generator.IDGenerator")
	@GeneratedValue(generator="loan_id")
	private Long id;
	
	@Column(name = "balance")
	private Double balance;

	@ManyToOne
	@JoinColumn(name = "loanType")
	private LoanType type;
	
	@Column(name = "holder_name")
	private String holderName;

}
