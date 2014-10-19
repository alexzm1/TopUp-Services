/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topup.services.user.service;

import org.springframework.security.core.context.SecurityContextHolder;

import com.topup.services.user.domain.model.UserProfile;

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
