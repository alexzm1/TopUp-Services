/**
 *
 */
package com.topup.services.config;

import com.mongodb.Mongo;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.UnknownHostException;

/**
 * <b>TestContext</b>
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 *
 */
@Configuration
public class TestContext {

    /**
     * Returns an instance of {@link Mongo}
     *
     * @return An instance of {@link Mongo}
     * @throws UnknownHostException
     */
    @Bean
    public Mongo getMongo() throws UnknownHostException {
        return Mockito.mock(Mongo.class);
    }
}
