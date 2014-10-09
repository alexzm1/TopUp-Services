package com.topup.services.config;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import com.topup.services.security.service.UserProfileService;
import com.topup.services.security.service.UserProfileServiceImpl;

/**
 * 
 * <b>AppConfig</b>
 *
 * Application configuration class
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
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

	/**
	 * Returns a Mongo instance
	 * 
	 * NOTE: Move the connection data into a JNDI
	 * 
	 * @return An instance of {@link Mongo}
	 * @throws UnknownHostException
	 */
	@Bean
	public Mongo getMongo() throws UnknownHostException {
		final Mongo mongo = new MongoClient("127.0.0.1");
		mongo.setWriteConcern(WriteConcern.SAFE);
		return mongo;
	}

}
