/**
 * 
 */
package com.topup.services.security.service;

import org.springframework.security.oauth.provider.token.OAuthProviderTokenImpl;
import org.springframework.security.oauth.provider.token.OAuthProviderTokenServices;
import org.springframework.security.oauth.provider.token.RandomValueProviderTokenServices;

/**
 * @author Samuel Alejandro
 *
 */
public class OAuthProviderTokenServicesImpl extends
		RandomValueProviderTokenServices implements OAuthProviderTokenServices {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.oauth.provider.token.
	 * RandomValueProviderTokenServices#readToken(java.lang.String)
	 */
	@Override
	protected OAuthProviderTokenImpl readToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.oauth.provider.token.
	 * RandomValueProviderTokenServices#storeToken(java.lang.String,
	 * org.springframework.security.oauth.provider.token.OAuthProviderTokenImpl)
	 */
	@Override
	protected void storeToken(String tokenValue, OAuthProviderTokenImpl token) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.oauth.provider.token.
	 * RandomValueProviderTokenServices#removeToken(java.lang.String)
	 */
	@Override
	protected OAuthProviderTokenImpl removeToken(String tokenValue) {
		// TODO Auto-generated method stub
		return null;
	}

}
