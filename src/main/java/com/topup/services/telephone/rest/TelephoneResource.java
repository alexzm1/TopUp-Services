package com.topup.services.telephone.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.topup.services.telephone.domain.model.AddBalanceRequest;
import com.topup.services.telephone.service.AccountService;
import com.topup.services.user.domain.model.UserProfile;

/**
 * Account Resource
 * 
 * @author alexzm1
 *
 */
@RestController
@RequestMapping("/api/telephone")
public class TelephoneResource {

	private AccountService accountService;

	@Autowired
	public TelephoneResource(AccountService accountService) {
		this.accountService = accountService;
	}

	/**
	 * Returns the Status of the mobile number
	 * 
	 * @param mobileNumber
	 *            Mobile number
	 * @return Instance of
	 *         {@link com.topup.services.user.domain.model.UserProfile}
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{mobile_number}")
	@ResponseStatus(HttpStatus.OK)
	public UserProfile getMobileNumberIdStatus(
			@PathVariable("mobile_number") String mobileNumber) {
		UserProfile profile = new UserProfile();
		profile.setId(mobileNumber);
		profile.setPhoneNumber(mobileNumber);
		profile.setStatus(accountService.getAccountStatus(mobileNumber));
		return profile;
	}

	/**
	 * Add balance to the received telephone number using the payment
	 * information provided
	 * 
	 * @param mobileNumber
	 *            Mobile Number.
	 * @param addBalanceRequest
	 *            Instance of
	 *            {@link com.topup.services.telephone.domain.model.AddBalanceRequest}
	 *            Including the information required to add balance to the
	 *            received mobile number.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "{mobile_number}/topup", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void addBalance(@PathVariable("mobile_number") String mobileNumber,
			@RequestBody AddBalanceRequest addBalanceRequest) {

		addBalanceRequest.setMobileNumber(mobileNumber);
		accountService.addBalance(addBalanceRequest);

	}
}
