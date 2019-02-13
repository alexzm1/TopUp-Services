package com.topup.services.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <b>Application</b>
 * <p>
 * MVC Configuration class
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 */
@Configuration
@ComponentScan("com.topup.services")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
