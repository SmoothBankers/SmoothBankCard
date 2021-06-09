package com.ss.sbank.de.cards;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "card")
@Data
public class Card {

	@Id
//	@GenericGenerator(name = "card_id", strategy = "com.ss.sbank.generator.IDGenerator")
//	@GeneratedValue(generator="card_id")
	private Long id;

	@Column(name = "csv")
	private Integer csv;

	@Column(name = "expiration_month")
	private Integer expiryMonth;

	@Column(name = "expiration_year")
	private Integer expiryYear;

	@Column(name = "balance")
	private Double balance;

	@Column(name = "cashback")
	private Double cashback;

	@ManyToOne
	@JoinColumn(name = "card_type")
	private CardType type;
	
	@Column(name = "holder_name")
	private String holderName;

}
