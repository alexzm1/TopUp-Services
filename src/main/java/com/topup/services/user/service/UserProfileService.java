/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topup.services.user.service;

import com.topup.services.user.domain.model.UserProfile;

/**
 * <b>UserProfileService</b>
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 */
public interface UserProfileService {

    /**
     * Returns an instance of {@link UserProfile}
     *
     * @return An instance of {@link UserProfile}
     */
    UserProfile getUserProfile();

}
