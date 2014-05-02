package com.topup.services.telephone.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topup.services.telephone.model.AddBalanceRequest;
import com.topup.services.telephone.model.CreditCardRequest;
import com.topup.services.telephone.service.AccountService;

/**
 * Account Resource
 * 
 * @author alexzm1
 *
 */
@Repository
@Path("/api")
public class AccountResource {

	private AccountService accountService;

	@Autowired
	public AccountResource(AccountService accountService) {
		this.accountService = accountService;
	}

	@POST
	@Path("telephone/topup/{mobile_number}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void addBalance(@PathParam("mobile_number") String mobileNumber,
			@FormParam("amount") String amount,
			@FormParam("creditCardNumber") String number,
			@FormParam("expirationMonth") String expirationMonth,
			@FormParam("expirationYear") String expirationYear,
			@FormParam("ccv") String ccv) {

		AddBalanceRequest addBalanceRequest = new AddBalanceRequest();

		addBalanceRequest.setMobileNumber(mobileNumber);
		
		addBalanceRequest.setAmount(amount);
		
		addBalanceRequest.setCreditCard(new CreditCardRequest());
		
		addBalanceRequest.getCreditCard().setCcv(ccv);
		
		addBalanceRequest.getCreditCard().setExpirationMonth(expirationMonth);
		
		addBalanceRequest.getCreditCard().setExpirationYear(expirationYear);

		addBalanceRequest.getCreditCard().setNumber(number);
		
		accountService.addBalance(addBalanceRequest);

		return;

	}
}
