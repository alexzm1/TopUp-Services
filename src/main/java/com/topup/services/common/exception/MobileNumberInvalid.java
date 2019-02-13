package com.topup.services.common.exception;

/**
 * <b>MobileNumberInvalid</b>
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 */
public class MobileNumberInvalid extends RuntimeException {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -1460277856864214148L;

    /**
     * <b>Constructor</b>
     *
     * @param mobileNumber
     */
    public MobileNumberInvalid(String mobileNumber) {
        super(
                String.format(
                        "Mobile Number %d is currently in an invalid state service, please try again with a valid mobile number",
                        mobileNumber));
    }

}
