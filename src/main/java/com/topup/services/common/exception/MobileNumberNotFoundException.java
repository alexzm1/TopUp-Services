/**
 * 
 */
package com.topup.services.common.exception;

import java.text.MessageFormat;

/**
 * <b>MobileNumber Not Found Exception</b> Thrown when a mobile number was not
 * found in the database happening in an API end point where the mobile number
 * was supposed to be already validated
 * 
 * @author alexzm1
 *
 */
public class MobileNumberNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6790158796340847227L;

	public MobileNumberNotFoundException(String mobileNumber) {
		super(
				MessageFormat
						.format("Mobile Number {0} is not a mobile number we give service, please try again with a valid mobile number",
								mobileNumber));
	}

}
