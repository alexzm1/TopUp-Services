package com.topup.services.config;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 
 * <b>MongoDBConfigTest</b>
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 *
 */
public class MongoDBConfigTest {

	@Test
	public void testMongoDBAppContext() {
		final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				TestContext.class, MongoDBConfig.class);
		assertTrue(Arrays.asList(applicationContext.getBeanDefinitionNames())
				.contains("mobileNumbersRepository"));
		applicationContext.close();

	}

}
