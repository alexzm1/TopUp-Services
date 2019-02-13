package com.topup.services.telephone.domain.model;

import org.apache.commons.lang3.StringUtils;

/**
 * <b>MobileStatus</b>
 * <p>
 * Mobile Status
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 */
public enum MobileStatus {
    ACTIVE, INACTIVE, NO_REGISTER, INVALID;

    /**
     * Return an instance of {@link MobileStatus} from the status string
     *
     * @param status
     * @return An instance of {@link MobileStatus}
     */
    public static MobileStatus valueFromString(String status) {
        switch (StringUtils.defaultString(status)) {
            case "ACTIVE":
                return ACTIVE;
            case "INACTIVE":
                return INACTIVE;
            case "NO_REGISTER":
                return NO_REGISTER;
            case "INVALID":
            default:
                return INVALID;
        }
    }

}