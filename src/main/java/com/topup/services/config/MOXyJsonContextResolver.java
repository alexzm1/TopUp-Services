/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topup.services.config;

import javax.ws.rs.ext.ContextResolver;
import org.eclipse.persistence.jaxb.JAXBContextProperties;
import org.glassfish.jersey.moxy.json.MoxyJsonConfig;

/**
 *
 * @author Samuel Alejandro
 */
public class MOXyJsonContextResolver implements ContextResolver<MoxyJsonConfig> {

    private final MoxyJsonConfig config;

    public MOXyJsonContextResolver() {
        config = new MoxyJsonConfig()
                .setAttributePrefix("")
                .setValueWrapper("value")
                .property(JAXBContextProperties.JSON_WRAPPER_AS_ARRAY_NAME, true);
    }

    @Override
    public MoxyJsonConfig getContext(Class<?> type) {
        return config;
    }

}
