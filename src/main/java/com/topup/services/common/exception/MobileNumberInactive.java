/**
 * 
 */
package com.topup.services.common.exception;


/**
 * <b>MobileNumberInactive</b>
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 *
 */
public class MobileNumberInactive extends RuntimeException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8275608504655077239L;

	/**
	 * 
	 * <b>Constructor</b>
	 *
	 * @param mobileNumber
	 */
	public MobileNumberInactive(String mobileNumber) {
		super(
				String.format(
						"Mobile Number %d is currently in an inactive state of service, please try again with a valid mobile number",
						mobileNumber));
	}
}
