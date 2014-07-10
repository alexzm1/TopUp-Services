package com.topup.services.telephone.domain.model;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * <b>Credit Card Request</b> Bean representation of the Credit Card object
 * received in the JSON request to do a top up
 * 
 * @author alexzm1
 *
 */
public class CreditCardRequest {

	private static final String MONTH_YEAR_REGEXP = "[0-9][0-9]";

	@NotEmpty
	private String number;

	@NotEmpty
	@Pattern(regexp = MONTH_YEAR_REGEXP)
	private String expirationMonth;

	@NotEmpty
	@Pattern(regexp = MONTH_YEAR_REGEXP)
	private String expirationYear;

	@NotEmpty
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
