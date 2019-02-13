package com.topup.services.config;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * <b>MongoDBConfigTest</b>
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
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
