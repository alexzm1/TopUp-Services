/**
 * 
 */
package com.topup.services.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth.common.OAuthException;
import org.springframework.security.oauth.provider.ConsumerDetails;
import org.springframework.security.oauth.provider.ConsumerDetailsService;

import com.topup.services.security.domain.model.OauthConsumerDetails;

/**
 *
 * <b>OAuthConsumerDetailsService.java</b>
 *
 * @author alexzm1
 * @since 1.1.0
 * @version 1.1.0
 *
 */
public class OAuthConsumerDetailsService implements ConsumerDetailsService {
	String consumerName = "TOP-UP UI";
	String consumerKey = "3a4393c3da1a4e316ee66c0cc61c71";
	String consumerSecret = "fe1372c074185b19c309964812bb8f3f2256ba514aea8a318";

	@Override
	public ConsumerDetails loadConsumerByConsumerKey(String consumerKey)
			throws OAuthException {
		if (consumerKey == null)
			throw new OAuthException(
					"No credentials found for the consumer key [" + consumerKey
							+ "]");

		if (!consumerKey.equals(this.consumerKey))
			throw new OAuthException(
					"No credentials found for the consumer key [" + consumerKey
							+ "]");

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_OAUTH"));

		return new OauthConsumerDetails(consumerName, consumerKey,
				consumerSecret, authorities);
	}

}
