package com.ss.sbank.de.cards;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CARDTYPE")
@Data
public class CardType {

	@Id
	private Integer id;
	private String title;
	private String description;
	private Double rate;

}