package com.topup.services.telephone.service;

import com.topup.services.telephone.model.AddBalanceRequest;

/**
 * Account service
 * 
 * @author alexzm1
 *
 */
public interface AccountService {

	/**
	 * Add balance to the Account specified in the received AddBalanceRequest
	 * object
	 * 
	 * @param request
	 *            Instance of AddBalanceRequest with the Account information to
	 *            required to add Balance
	 */
	void addBalance(AddBalanceRequest request);

	/**
	 * Returns the Account status
	 * 
	 * @param number
	 *            Number tied to the account
	 * @return Returns true if the Account is valid, false if it doesn't
	 */
	boolean getAccountStatus(String number);

}
