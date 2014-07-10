package com.topup.services.telephone.domain.model;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 
 * <b>Add balance request</b>
 * 
 * Bean representation of the JSON request received to do a top up
 * 
 * @author alexzm1
 *
 */
public class AddBalanceRequest {

	private String mobileNumber;

	@NotNull
	@Min(value = 1)
	private int amount;

	@Valid
	@NotNull
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
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(int amount) {
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
