/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topup.services.security.service;

import org.springframework.security.core.context.SecurityContextHolder;

import com.topup.services.security.domain.model.UserProfile;

/**
 * <b>User Profile Service Implementation</b>
 * 
 * @author alexzm1
 */
public class UserProfileServiceImpl implements UserProfileService {

	@Override
	public UserProfile getUserProfile() {
		return (UserProfile) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
	}

}
