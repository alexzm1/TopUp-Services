package com.topup.services.telephone.rest;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.topup.services.telephone.model.AddBalanceRequest;
import com.topup.services.telephone.service.AccountService;

/**
 * Account Resource
 * 
 * @author alexzm1
 *
 */
@Controller
@RequestMapping("/api")
public class AccountResource {

	private AccountService accountService;

	@Autowired
	public AccountResource(AccountService accountService) {
		this.accountService = accountService;
	}

	@RequestMapping(method = RequestMethod.POST, value = "telephone/topup/{mobile_number}", consumes = MediaType.APPLICATION_FORM_URLENCODED, produces = MediaType.APPLICATION_JSON)
	public void addBalance(@PathParam("mobile_number") String mobileNumber,
			@RequestBody AddBalanceRequest addBalanceRequest) {

		addBalanceRequest.setMobileNumber(mobileNumber);

		accountService.addBalance(addBalanceRequest);

		return;

	}
}
