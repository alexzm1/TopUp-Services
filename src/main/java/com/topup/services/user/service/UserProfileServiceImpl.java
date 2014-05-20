/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topup.services.user.service;

import com.topup.services.user.domain.model.UserProfile;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author alexzm1
 */
public class UserProfileServiceImpl implements UserProfileService {

    @Override
    public UserProfile getUserProfile() {
        return (UserProfile) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
