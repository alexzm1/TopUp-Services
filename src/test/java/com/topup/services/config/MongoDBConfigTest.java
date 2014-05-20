package com.topup.services.config;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MongoDBConfigTest {

	@Test
	public void testMongoDBAppContext() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				MongoDBConfig.class);
		assertTrue(Arrays.asList(applicationContext.getBeanDefinitionNames())
				.contains("mobileNumbersRepository"));
		applicationContext.close();

	}
}
