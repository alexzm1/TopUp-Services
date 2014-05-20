package com.topup.services.telephone.domain.model;


public class CreditCardRequest {

	private String number;

	private String expirationMonth;

	private String expirationYear;

	private String ccv;

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
	 * @return the expirationMonth
	 */
	public String getExpirationMonth() {
		return expirationMonth;
	}

	/**
	 * @param expirationMonth
	 *            the expirationMonth to set
	 */
	public void setExpirationMonth(String expirationMonth) {
		this.expirationMonth = expirationMonth;
	}

	/**
	 * @return the expirationYear
	 */
	public String getExpirationYear() {
		return expirationYear;
	}

	/**
	 * @param expirationYear
	 *            the expirationYear to set
	 */
	public void setExpirationYear(String expirationYear) {
		this.expirationYear = expirationYear;
	}

	/**
	 * @return the ccv
	 */
	public String getCcv() {
		return ccv;
	}

	/**
	 * @param ccv
	 *            the ccv to set
	 */
	public void setCcv(String ccv) {
		this.ccv = ccv;
	}

}
