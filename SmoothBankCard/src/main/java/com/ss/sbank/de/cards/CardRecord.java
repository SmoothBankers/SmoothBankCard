package com.ss.sbank.de.cards;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ss.sbank.de.holder.Holder;

import lombok.Data;

@Table(name = "CARDRECORD")
@Entity
@Data
public class CardRecord {
	
	@OneToOne
	@JoinColumn(name = "holder_id")
	private Holder holder;
	
	@OneToOne
	@JoinColumn(name = "card_id")
	private Card card;
	
	@Column(name="active")
	private boolean active = false;
	
	@Id
	@GeneratedValue
	private int id;

}
