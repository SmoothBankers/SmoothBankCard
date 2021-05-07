package com.ss.utopia.de;

public class CardType {

	public enum Type {
		credit, debit;
	}

	private Double interestRate;
	private Boolean cashBackCapable;
	private String description;
	private String name;
	private Type type;

	/**
	 * @return the interestRate
	 */
	public Double getInterestRate() {
		return interestRate;
	}

	/**
	 * @param interestRate the interestRate to set
	 */
	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	/**
	 * @return the cashBackCapable
	 */
	public Boolean getCashBackCapable() {
		return cashBackCapable;
	}

	/**
	 * @param cashBackCapable the cashBackCapable to set
	 */
	public void setCashBackCapable(Boolean cashBackCapable) {
		this.cashBackCapable = cashBackCapable;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cashBackCapable == null) ? 0 : cashBackCapable.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((interestRate == null) ? 0 : interestRate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		CardType other = (CardType) obj;
		if (cashBackCapable == null) {
			if (other.cashBackCapable != null)
				return false;
		} else if (!cashBackCapable.equals(other.cashBackCapable))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (interestRate == null) {
			if (other.interestRate != null)
				return false;
		} else if (!interestRate.equals(other.interestRate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CardType [" + (interestRate != null ? "interestRate=" + interestRate + ", " : "")
				+ (cashBackCapable != null ? "cashBackCapable=" + cashBackCapable + ", " : "")
				+ (description != null ? "description=" + description + ", " : "")
				+ (name != null ? "name=" + name + ", " : "") + (type != null ? "type=" + type : "") + "]";
	}

}
