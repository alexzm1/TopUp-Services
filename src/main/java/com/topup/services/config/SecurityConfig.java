package com.topup.services.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth.config.OAuthProviderBeanDefinitionParser;

import com.topup.services.security.domain.model.Authorities;

/**
 * 
 * <b>SecurityConfig</b>
 *
 * Spring Security Configuration
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 *
 */
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsServiceImpl;

	/**
	 * <B>NOTE:</B> Use only for Unit Testing purpose
	 * 
	 * @param userDetailsServiceImpl
	 *            the userDetailsServiceImpl to set
	 */
	void setUserDetailsServiceImpl(UserDetailsService userDetailsServiceImpl) {
		this.userDetailsServiceImpl = userDetailsServiceImpl;
	}
	
	public BeanDefinitionParser getOAuthProviderBeanDefinitionParser(){
		return new OAuthProviderBeanDefinitionParser();
	}

	/**
	 * Configure global authentication manager
	 * 
	 * @param authenticationManagerBuilder
	 *            Instance of
	 *            {@link org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder}
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(
			AuthenticationManagerBuilder authenticationManagerBuilder)
			throws Exception {
		final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsServiceImpl);
		authenticationManagerBuilder
				.authenticationProvider(authenticationProvider);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/**")
				.permitAll()
				.antMatchers("api/secure/**")
				.hasAnyAuthority(Authorities.ADMIN_USER.toString(),
						Authorities.MOBILE_USER.toString());
	}
}
