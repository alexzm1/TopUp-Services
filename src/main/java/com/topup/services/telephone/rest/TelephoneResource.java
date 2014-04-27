package com.topup.services.telephone.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.topup.services.user.service.MobileNumberService;

public class TelephoneResource {

	private MobileNumberService mobileNumberService;

	@Autowired
	public TelephoneResource(MobileNumberService mobileNumberService) {
		this.mobileNumberService = mobileNumberService;
	}

	@POST
	@Path("telephone/topup/{mobile_number}")
	@Produces(MediaType.APPLICATION_JSON)
	public void addBalance(@PathParam("mobile_number") String mobileNumber) {

		boolean status = mobileNumberService.getNumberStatus(mobileNumber);
		
		if(status){
			
		}

	}
}
