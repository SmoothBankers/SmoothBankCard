package com.ss.sbank.de.cards;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="card")
public class Card {

	@Id
	private Integer id;

	private Integer csv;
	private Integer expiryMonth;
	private Integer expiryYear;
	private Double balance;
	private Double cashback;

	@ManyToOne
	private CardType type;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the csv
	 */
	public Integer getCsv() {
		return csv;
	}

	/**
	 * @param csv the csv to set
	 */
	public void setCsv(Integer csv) {
		this.csv = csv;
	}

	/**
	 * @return the expiryMonth
	 */
	public Integer getExpiryMonth() {
		return expiryMonth;
	}

	/**
	 * @param expiryMonth the expiryMonth to set
	 */
	public void setExpiryMonth(Integer expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	/**
	 * @return the expiryYear
	 */
	public Integer getExpiryYear() {
		return expiryYear;
	}

	/**
	 * @param expiryYear the expiryYear to set
	 */
	public void setExpiryYear(Integer expiryYear) {
		this.expiryYear = expiryYear;
	}

	/**
	 * @return the type
	 */
	public CardType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(CardType type) {
		this.type = type;
	}

	/**
	 * @return the balance
	 */
	public Double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	/**
	 * @return the cashback
	 */
	public Double getCashback() {
		return cashback;
	}

	/**
	 * @param cashback the cashback to set
	 */
	public void setCashback(Double cashback) {
		this.cashback = cashback;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((cashback == null) ? 0 : cashback.hashCode());
		result = prime * result + ((csv == null) ? 0 : csv.hashCode());
		result = prime * result + ((expiryMonth == null) ? 0 : expiryMonth.hashCode());
		result = prime * result + ((expiryYear == null) ? 0 : expiryYear.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (cashback == null) {
			if (other.cashback != null)
				return false;
		} else if (!cashback.equals(other.cashback))
			return false;
		if (csv == null) {
			if (other.csv != null)
				return false;
		} else if (!csv.equals(other.csv))
			return false;
		if (expiryMonth == null) {
			if (other.expiryMonth != null)
				return false;
		} else if (!expiryMonth.equals(other.expiryMonth))
			return false;
		if (expiryYear == null) {
			if (other.expiryYear != null)
				return false;
		} else if (!expiryYear.equals(other.expiryYear))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Card [" + (id != null ? "id=" + id + ", " : "") + (csv != null ? "csv=" + csv + ", " : "")
				+ (expiryMonth != null ? "expiryMonth=" + expiryMonth + ", " : "")
				+ (expiryYear != null ? "expiryYear=" + expiryYear + ", " : "")
				+ (balance != null ? "balance=" + balance + ", " : "")
				+ (cashback != null ? "cashback=" + cashback + ", " : "") + (type != null ? "type=" + type : "") + "]";
	}

}
