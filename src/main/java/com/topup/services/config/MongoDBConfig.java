package com.topup.services.config;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;

/**
 * 
 * <b>MongoDBConfig</b>
 *
 * MongoDB Configuration class
 * 
 * <P>
 * Host: 127.0.0.1
 * </P>
 * <P>
 * Port: 27017
 * </P>
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 *
 */
@Configuration
@ComponentScan(basePackages = "com.topup.services.common.repository")
@EnableMongoRepositories(basePackages = "com.topup.services.common.repository")
public class MongoDBConfig extends AbstractMongoConfiguration {

	private Mongo mongo;

	/**
	 * 
	 * @param mongo
	 *            An instance of {@link Mongo}
	 */
	@Autowired
	public void setMongo(Mongo mongo) {
		this.mongo = mongo;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getDatabaseName() {
		return "jbosswildfly";
	}

	/**
	 * If the db.properties file is available in the classpath (usually only in
	 * the openshift servers), it will setup a {@link UserCredentials} object
	 * with the included username and password, else it will return a
	 * {@code null} object
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected UserCredentials getUserCredentials() {
		try {
			final Properties dbProperties = PropertiesLoaderUtils
					.loadAllProperties("db.properties");
			if (!dbProperties.isEmpty()) {
				return new UserCredentials(
						dbProperties.getProperty("db.username"),
						dbProperties.getProperty("db.password"));
			}
			return null;
		} catch (IOException e) {
			return null;
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Mongo mongo() throws Exception {
		return mongo;
	}

}
