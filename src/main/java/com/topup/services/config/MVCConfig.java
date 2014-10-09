package com.topup.services.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 
 * <b>MVCConfig</b>
 *
 * MVC Configuration class
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.topup.services")
public class MVCConfig {

}
