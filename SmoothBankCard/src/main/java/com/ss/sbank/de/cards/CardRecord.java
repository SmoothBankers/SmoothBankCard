package com.ss.sbank.de.cards;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ss.sbank.de.holder.Holder;

import lombok.Data;

@Table(name = "CARDRECORD")
@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CardRecord {
	
	@OneToOne
	@JoinColumn(name = "holder_id")
	private Holder holder;
	
	@OneToOne
	@JoinColumn(name = "card_id")
	private Card card;
	
	@Column(name="active")
	private boolean active = false;
	
	@Column(name="confirmed")
	private boolean confirmed = false;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "sign_up_date")
	private Date signUpDate;

}
