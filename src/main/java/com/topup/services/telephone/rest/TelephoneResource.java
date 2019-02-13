package com.topup.services.telephone.rest;

import com.topup.services.telephone.domain.model.AddBalanceRequest;
import com.topup.services.telephone.domain.model.Mobile;
import com.topup.services.telephone.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <b>TelephoneResource</b>
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/api/telephone")
public class TelephoneResource {

    private final AccountService accountService;

    /**
     * <b>Constructor</b>
     *
     * @param accountService An instance of {@link AccountService}
     */
    @Autowired
    public TelephoneResource(final AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * Returns the Status of the mobile number
     *
     * @param mobileNumber Mobile number
     * @return Instance of
     * {@link com.topup.services.telephone.domain.model.Mobile}
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{mobile_number}")
    public Mobile getMobileStatus(
            @PathVariable("mobile_number") final String mobileNumber) {
        return accountService.getMobileByNumber(mobileNumber);
    }

    /**
     * Add balance to the received telephone number using the payment
     * information provided
     *
     * @param mobileNumber      Mobile Number.
     * @param addBalanceRequest Instance of
     *                          {@link com.topup.services.telephone.domain.model.AddBalanceRequest}
     *                          Including the information required to add balance to the
     *                          received mobile number.
     */
    @RequestMapping(method = RequestMethod.POST, value = "{mobile_number}/topup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void addBalance(
            @PathVariable("mobile_number") final String mobileNumber,
            @RequestBody @Valid final AddBalanceRequest addBalanceRequest) {
        addBalanceRequest.setMobileNumber(mobileNumber);
        accountService.addBalance(addBalanceRequest);

    }
}
