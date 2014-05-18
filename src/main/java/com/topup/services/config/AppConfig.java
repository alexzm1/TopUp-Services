package com.topup.services.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import com.topup.services.user.service.UserProfileService;
import com.topup.services.user.service.UserProfileServiceImpl;

/**
 * 
 * Application configuration class
 *
 */
@Configuration
public class AppConfig {

	/**
	 * Returns instance of UserProfileService for the request
	 * 
	 * @return A request instance of
	 *         {@link com.topup.services.user.service.UserProfileService}
	 */
	@Bean
	@Scope(WebApplicationContext.SCOPE_REQUEST)
	public UserProfileService getUserProfileService() {
		return new UserProfileServiceImpl();
	}

}
