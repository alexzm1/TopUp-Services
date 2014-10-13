package com.topup.services.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
@ComponentScan(basePackages = { "com.topup.services.common.repository",
		"com.topup.services.security.repository" })
@EnableMongoRepositories(basePackages = {
		"com.topup.services.common.repository",
		"com.topup.services.security.repository" })
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
		return "TopUp";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Mongo mongo() throws Exception {
		return mongo;
	}

}
