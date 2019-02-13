package com.topup.services.telephone.domain.model;

/**
 * <b>Mobile</b>
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 */
public class Mobile {

    private final String number;

    private final MobileStatus status;

    /**
     * <b>Constructor</b>
     *
     * @param number
     * @param status An instance of {@link MobileStatus}
     */
    public Mobile(String number, MobileStatus status) {
        this.number = number;
        this.status = status;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @return the status
     */
    public MobileStatus getStatus() {
        return status;
    }

}
