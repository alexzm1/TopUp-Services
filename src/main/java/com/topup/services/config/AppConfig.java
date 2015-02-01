/**
 * 
 */
package com.topup.services.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 
 * <b>AppConfig</b>
 *
 * Application configuration class
 *
 * @author alexzm1
 * @version 1.1
 * @since 1.0
 *
 */
@Configuration
@ComponentScan("com.topup.services")
@ImportResource("classpath:/oauth-configuration.xml")
public class AppConfig {

}