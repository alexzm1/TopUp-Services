package com.topup.services.telephone.service;

import com.topup.services.telephone.domain.model.AddBalanceRequest;
import com.topup.services.telephone.domain.model.Mobile;

/**
 * <b>AccountService</b>
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 */
public interface AccountService {

    /**
     * Add balance to the Account specified in the received AddBalanceRequest
     * object
     *
     * @param request Instance of AddBalanceRequest with the Account information to
     *                required to add Balance
     */
    void addBalance(AddBalanceRequest request);

    /**
     * Returns the matching Mobile from the DataBase
     *
     * @param number Number tied to the account
     * @return Returns an instance of
     * {@link com.topup.services.telephone.domain.model.Mobile}
     */
    Mobile getMobileByNumber(String number);

}
