/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topup.services.user.rest;

import com.topup.services.user.model.UserProfile;
import com.topup.services.user.service.UserProfileService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Samuel Alejandro
 */
@Repository
@Path("/api")
public class ProfileResource {

    @Autowired
    private UserProfileService userProfileService;

    @GET
    @PreAuthorize("hasRole('ROLE_DUMMY')")
    @Path("secure/user")
    @Produces(MediaType.APPLICATION_JSON)
    public UserProfile getProfile() {
        return userProfileService.getUserProfile();
    }

    @GET
    @Path("user/{mobile_number}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserProfile getMobileNumberIdStatus(@PathParam("mobile_number") String mobileNumber) {
        UserProfile profile = new UserProfile();
        profile.setId("87362786");
        profile.setPhoneNumber("287765654");
        return profile;
    }

}
