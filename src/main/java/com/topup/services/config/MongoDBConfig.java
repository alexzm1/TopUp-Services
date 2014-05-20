package com.topup.services.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

/**
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
 *
 */
@Configuration
@ComponentScan(basePackages = "com.topup.services.common.repository")
@EnableMongoRepositories(basePackages = "com.topup.services.common.repository")
public class MongoDBConfig extends AbstractMongoConfiguration {

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.mongodb.config.AbstractMongoConfiguration#
	 * getDatabaseName()
	 */
	@Override
	protected String getDatabaseName() {
		return "TopUp";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.data.mongodb.config.AbstractMongoConfiguration#mongo
	 * ()
	 */
	@Override
	public Mongo mongo() throws Exception {
		Mongo mongo = new MongoClient("127.0.0.1");
		mongo.setWriteConcern(WriteConcern.SAFE);
		return mongo;
	}

}
