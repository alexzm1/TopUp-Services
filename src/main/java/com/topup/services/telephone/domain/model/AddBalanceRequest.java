package com.topup.services.telephone.domain.model;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 
 * <b>AddBalanceRequest</b>
 *
 * Bean representation of the JSON request received to do a top up
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 *
 */
public class AddBalanceRequest {

	private String mobileNumber;

	@NotNull
	@Min(value = 5)
	private BigDecimal amount;

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
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(BigDecimal amount) {
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
