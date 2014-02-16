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
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Samuel Alejandro
 */
@Component
@Path("/user")
public class ProfileResource {

    @Autowired
    private UserProfileService userProfileService;

    @GET
    public UserProfile getProfile() {
        return userProfileService.getUserProfile();
    }
    
    @GET
    @Path("/test")
    //@Produces("appli")
    public UserProfile testProfile(){
        return new UserProfile();
    }

}
