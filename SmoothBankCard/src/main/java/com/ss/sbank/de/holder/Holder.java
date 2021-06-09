package com.ss.sbank.de.holder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "holder")
@Data
/**
 * This class is a general use data entity used to keep track of registration
 * information of individuals who apply for cards and/or loans whether they have
 * an user account or not.
 * 
 * @author Parker W.
 *
 */
public class Holder {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "holder_name")
	private String holderName;

	@Column(name = "home_phone")
	private String homePhone;

	@Column(name = "cell_phone")
	private String cellPhone;

	@Column(name = "work_phone")
	private String workPhone;

	@Column(name = "email")
	private String email;

	@Column(name = "ssn")
	private String ssn;

	@Column(name = "address")
	private String address;
	
	@Column(name="po_box")
	private String po_box;

	@Column(name = "zipcode")
	private Integer zipcode;

	@Column(name = "monthly_income")
	private Integer monthlyIncome;

}
