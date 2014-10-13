package com.topup.services.common.exception;

/**
 * 
 * <b>MobileNumberNotFoundException</b>
 *
 * Thrown when a mobile number was not found in the database happening in an API
 * end point where the mobile number was supposed to be already validated
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 *
 */
public class MobileNumberNotFoundException extends RuntimeException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6790158796340847227L;

	/**
	 * 
	 * <b>Constructor</b>
	 *
	 * @param mobileNumber
	 */
	public MobileNumberNotFoundException(String mobileNumber) {
		super(
				String.format(
						"Mobile Number %s is not a mobile number we give service, please try again with a valid mobile number",
						mobileNumber));
	}

}
