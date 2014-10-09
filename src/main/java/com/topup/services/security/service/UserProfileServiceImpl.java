package com.topup.services.security.service;

import org.springframework.security.core.context.SecurityContextHolder;

import com.topup.services.security.domain.model.UserProfile;

/**
 * 
 * <b>UserProfileServiceImpl</b>
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 *
 */
public class UserProfileServiceImpl implements UserProfileService {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserProfile getUserProfile() {
		return (UserProfile) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
	}

}
