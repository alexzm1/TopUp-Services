/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topup.services.user.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.topup.services.telephone.service.AccountService;
import com.topup.services.user.model.UserProfile;
import com.topup.services.user.service.UserProfileService;

/**
 * Profile Resource
 * 
 * @author alexzm1
 */
@Controller
@RequestMapping("/api")
public class ProfileResource {

	private UserProfileService userProfileService;

	private AccountService accountService;

	@Autowired
	public ProfileResource(UserProfileService userProfileService,
			AccountService accountService) {
		this.userProfileService = userProfileService;
		this.accountService = accountService;
	}

	/**
	 * Returns the Status of the mobile number
	 * 
	 * @param mobileNumber
	 *            Mobile number
	 * @return Instance of {@link com.topup.services.user.model.UserProfile}
	 */
	@RequestMapping(method = RequestMethod.GET, value = "user/{mobile_number}")
	public UserProfile getMobileNumberIdStatus(
			@PathVariable("mobile_number") String mobileNumber) {
		UserProfile profile = new UserProfile();
		profile.setId(mobileNumber);
		profile.setPhoneNumber(mobileNumber);
		profile.setStatus(accountService.getAccountStatus(mobileNumber));
		return profile;
	}

	@PreAuthorize("hasRole('ROLE_DUMMY')")
	@RequestMapping(method = RequestMethod.GET, value = "secure/user")
	public UserProfile getProfile() {
		return userProfileService.getUserProfile();
	}

}
