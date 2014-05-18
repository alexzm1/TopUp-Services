package com.topup.services.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.topup.services.user.service.UserProfileService;
import com.topup.services.user.service.UserProfileServiceImpl;

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
	 *         {@link com.topup.services.user.service.UserProfileService}
	 */
	@Bean
	// @Scope(WebApplicationContext.SCOPE_REQUEST)
	// FIXME: bean
	// UserProfileService should be working per request scope
	public UserProfileService getUserProfileService() {
		return new UserProfileServiceImpl();
	}

}
