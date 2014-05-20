package com.topup.services.telephone.domain.model;

/**
 * 
 * @author alexzm1
 *
 */
public class AddBalanceRequest {

	private String mobileNumber;

	private String amount;

	private CreditCardRequest creditCard;

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber
	 *            the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return the creditCard
	 */

	public CreditCardRequest getCreditCard() {
		return creditCard;
	}

	/**
	 * @param creditCard
	 *            the creditCard to set
	 */

	public void setCreditCard(CreditCardRequest creditCard) {
		this.creditCard = creditCard;
	}

}
