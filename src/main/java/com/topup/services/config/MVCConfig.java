package com.topup.services.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * MVC Configuration class
 * 
 * @author alexzm1
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.topup.services")
public class MVCConfig {

}
