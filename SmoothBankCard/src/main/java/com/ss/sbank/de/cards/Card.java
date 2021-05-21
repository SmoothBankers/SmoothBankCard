package com.ss.sbank.de.cards;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "card")
@Data
public class Card {

	@Id
	private Long id;

	@Column(name = "csv")
	private Integer csv;

	@Column(name = "expiryMonth")
	private Integer expiryMonth;

	@Column(name = "expiryYear")
	private Integer expiryYear;

	@Column(name = "balance")
	private Double balance;

	@Column(name = "cashback")
	private Double cashback;

	@ManyToOne
	@JoinColumn(name = "cardType")
	private CardType type;
	
	@Column(name = "holderName")
	private String holderName;

}
