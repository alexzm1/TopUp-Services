package com.topup.services.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import com.topup.services.security.service.UserProfileService;
import com.topup.services.security.service.UserProfileServiceImpl;

/**
 * 
 * Application configuration class
 * 
 * @author alexzm1
 *
 */
@Configuration
@ComponentScan("com.topup.services")
public class AppConfig {

	/**
	 * Returns instance of UserProfileService for the request
	 * 
	 * @return A request instance of
	 *         {@link com.topup.services.security.service.UserProfileService}
	 */
	@Bean
	@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.INTERFACES)
	public UserProfileService getUserProfileService() {
		return new UserProfileServiceImpl();
	}

}
