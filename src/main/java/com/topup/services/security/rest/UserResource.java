package com.topup.services.security.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.topup.services.security.domain.model.UserProfile;
import com.topup.services.security.service.UserProfileService;

/**
 * 
 * <b>UserResource</b>
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 *
 */
@RestController
@RequestMapping("/api/user")
public class UserResource {

	private UserProfileService userProfileService;

	/**
	 * 
	 * <b>Constructor</b>
	 *
	 * @param userProfileService
	 *            An instance of {@link UserProfileService}
	 */
	@Autowired
	public UserResource(UserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}

	/**
	 * Returns the user profile for authenticated users
	 * 
	 * @return Instance of
	 *         {@link com.topup.services.user.domain.model.UserProfile}
	 */
	@PreAuthorize("hasRole('ROLE_DUMMY')")
	@RequestMapping(method = RequestMethod.GET, value = "/")
	@ResponseStatus(HttpStatus.OK)
	public UserProfile getProfile() {
		return userProfileService.getUserProfile();
	}

}