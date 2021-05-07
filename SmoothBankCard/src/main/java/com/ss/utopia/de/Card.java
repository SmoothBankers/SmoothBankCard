package com.ss.utopia.de;

public class Card {

	// Holder may be referenced exclusively through the account, so fair chance this
	// field is not needed
//	private String holder;	

	private Integer id;
	private Integer csv;
	private Double balance;
	private Double cashback;
	private Account account = new Account(); // A blank, "default" account represents a demo card used just to show
												// cards on offer
	private CardType cardType;
	private boolean active;

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

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((cardType == null) ? 0 : cardType.hashCode());
		result = prime * result + ((cashback == null) ? 0 : cashback.hashCode());
		result = prime * result + ((csv == null) ? 0 : csv.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (active != other.active)
			return false;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (cardType == null) {
			if (other.cardType != null)
				return false;
		} else if (!cardType.equals(other.cardType))
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Card [" + (id != null ? "id=" + id + ", " : "") + (csv != null ? "csv=" + csv + ", " : "")
				+ (balance != null ? "balance=" + balance + ", " : "")
				+ (cashback != null ? "cashback=" + cashback + ", " : "")
				+ (account != null ? "account=" + account + ", " : "")
				+ (cardType != null ? "cardType=" + cardType + ", " : "") + "active=" + active + "]";
	}

	public Integer generateCode() {
		// TODO

		/**
		 * TODO- According to https://en.wikipedia.org/wiki/Payment_card_number : Cards
		 * have a number from 8-19 digits in length, 6-8 digits of the issuer
		 * identification number, digit one is the major industry identifier (visa,
		 * master, chase, etc.) thus it is [MII][IIN] Individual account identifier up
		 * to 12 digits in length, this is the number of the account tied to the card
		 * Single check digit determined using the Luhn Algorithm
		 */

		/**
		 * Luhn algorithm, a.k.a mod10 algorithm from right to left: double every second
		 * digit with the digit to the left of the check being the first to be doubled
		 * if this results in a number greater than 9 then add the digits together or
		 * subtract 9 (result is the same) take the sum of all digits INCLUDING check
		 * digit number is valid if sum % 10 == 0
		 * 
		 * The check digit (x) is obtained by computing the sum of the sum digits then
		 * computing 9 times that value modulo 10 I.E, ( (sum w/o check digit) * 9) % 10
		 * == checkDigit
		 */

		/**
		 * The card will NOT be assigned a number randomly, thus an auto-generated key
		 * is not to be expected. The unique number is provided for entry.
		 */

		// final Integer MII = 4;
		// final Integer IIN = 57203; //Arbitrary for now, just make sure there's no
		// conflict with an existing IIN if changed
		// Integer acn = this.account.getNumber();
		// getCheckDigit logic
		// return MII|IIN|ACN|CKD
		return null;

	}

	/**
	 * @return the cardType
	 */
	public CardType getCardType() {
		return cardType;
	}

	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

}
