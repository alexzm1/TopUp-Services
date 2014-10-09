package com.topup.services.security.service;

import com.topup.services.security.domain.model.UserProfile;

/**
 * 
 * <b>UserProfileService</b>
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 *
 */
public interface UserProfileService {

	/**
	 * Returns an instance of {@link UserProfile}
	 * 
	 * @return An instance of {@link UserProfile}
	 */
	UserProfile getUserProfile();

}