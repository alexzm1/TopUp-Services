package com.topup.services.telephone.domain.model;

/**
 * <b>Mobile</b>
 * 
 * @author alexzm1
 *
 */
public class Mobile {

	String number;

	public MobileStatus status;

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
	public MobileStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(MobileStatus status) {
		this.status = status;
	}

}
