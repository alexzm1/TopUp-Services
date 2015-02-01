package com.topup.services.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
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
@ImportResource("classpath:/oauth-configuration.xml")
public class MVCConfig {

}
