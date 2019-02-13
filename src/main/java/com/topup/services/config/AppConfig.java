package com.topup.services.config;

import com.topup.services.user.service.UserProfileService;
import com.topup.services.user.service.UserProfileServiceImpl;
import org.springframework.context.annotation.*;
import org.springframework.web.context.WebApplicationContext;

/**
 * <b>AppConfig</b>
 * <p>
 * Application configuration class
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 */
@Configuration
@ComponentScan("com.topup.services")
public class AppConfig {

    /**
     * Returns instance of UserProfileService for the request
     *
     * @return A request instance of
     * {@link com.topup.services.user.service.UserProfileService}
     */
    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.INTERFACES)
    public UserProfileService getUserProfileService() {
        return new UserProfileServiceImpl();
    }

}
