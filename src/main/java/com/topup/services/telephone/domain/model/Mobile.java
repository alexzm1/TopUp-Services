package com.topup.services.telephone.domain.model;

/**
 * Mobile
 * 
 * @author alexzm1
 *
 */
public class Mobile {

	String number;

	Status status;

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * Mobile Status
	 * 
	 * @author alexzm1
	 *
	 */
	public static enum Status {
		ACTIVE, INACTIVE, NO_REGISTER, INVALID
	}

}
