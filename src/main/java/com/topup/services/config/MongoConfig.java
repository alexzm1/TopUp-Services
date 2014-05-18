package com.topup.services.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.WriteConcern;

/**
 * Mongo Confiiguration class
 * 
 * @author alexzm1
 *
 */
@Configuration
@ComponentScan("com.topup.services.common.repository")
@EnableMongoRepositories
public class MongoConfig extends AbstractMongoConfiguration {

	@Autowired
	private List<Converter<?, ?>> converters;

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
	@SuppressWarnings("deprecation")
	@Override
	public Mongo mongo() throws Exception {

		Mongo template = new Mongo();
		template.setWriteConcern(WriteConcern.SAFE);
		return template;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.mongodb.config.AbstractMongoConfiguration#
	 * customConversions()
	 */
	@Override
	public CustomConversions customConversions() {
		return new CustomConversions(converters);
	}

}
