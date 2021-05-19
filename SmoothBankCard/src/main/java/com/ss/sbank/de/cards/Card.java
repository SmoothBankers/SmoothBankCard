package com.ss.sbank.de.cards;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "card")
@Getter
@Setter
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "csv")
	private Integer csv;

	@Column(name = "expiryMonth")
	private Integer expiryMonth;

	@Column(name = "expirtYear")
	private Integer expiryYear;

	@Column(name = "balance")
	private Double balance;

	@Column(name = "cashback")
	private Double cashback;

	@ManyToOne
	@JoinColumn(name = "cardType")
	private CardType type;

	// @ManyToOne
	// private User user;

}
