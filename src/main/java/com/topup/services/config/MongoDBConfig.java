package com.topup.services.config;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

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
@ComponentScan(basePackages = { "com.topup.services.common.repository",
		"com.topup.services.security.repository" })
@EnableMongoRepositories(basePackages = {
		"com.topup.services.common.repository",
		"com.topup.services.security.repository" })
public class MongoDBConfig extends AbstractMongoConfiguration {

	private final static Logger LOG = LoggerFactory
			.getLogger(MongoDBConfig.class);

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
				LOG.info("Using custom MongoDB settings");
				return new UserCredentials(
						dbProperties.getProperty("db.username"),
						dbProperties.getProperty("db.password"));
			}
			LOG.info("Using default MongoDB settings");
			return null;
		} catch (IOException e) {
			return null;
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Bean
	public Mongo mongo() throws Exception {
		final Properties dbProperties = PropertiesLoaderUtils
				.loadAllProperties("db.properties");
		if (!dbProperties.isEmpty()) {
			return createMongo(dbProperties.getProperty("db.host"));
		}
		return createMongo("127.0.0.1");
	}

	/**
	 * Creates a {@link Mongo} instance from the received host
	 * 
	 * @param host
	 * @return An instance of {@link Mongo}
	 * @throws UnknownHostException
	 */
	private Mongo createMongo(String host) throws UnknownHostException {
		LOG.info(String.format("Mongo DB connected to host: %s", host));
		final Mongo mongo = new MongoClient(host);
		mongo.setWriteConcern(WriteConcern.SAFE);
		return mongo;
	}

}
