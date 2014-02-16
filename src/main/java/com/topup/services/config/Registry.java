/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.topup.services.config;

import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author Samuel Alejandro
 */
public class Registry extends ResourceConfig {
    public Registry() {
        packages(true, "com.topup.services");
    }
}
