/**
 * 
 */
package com.topup.services.security.domain.model;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth.common.signature.SharedConsumerSecretImpl;
import org.springframework.security.oauth.common.signature.SignatureSecret;
import org.springframework.security.oauth.provider.ConsumerDetails;

import com.google.common.collect.ImmutableList;

/**
 *
 * <b>OauthConsumerDetails.java</b>
 *
 * @author alexzm1
 * @since 1.1.0
 * @version 1.1.0
 *
 */
public class OauthConsumerDetails implements ConsumerDetails {
	private static final long serialVersionUID = 1L;
	private final String consumerName;
	private final String consumerKey;
	private final SignatureSecret signatureSecret;
	private final List<GrantedAuthority> authorities;

	public OauthConsumerDetails(String consumerName, String consumerKey,
			String signatureSecret, List<GrantedAuthority> authorities) {
		this.consumerName = consumerName;
		this.consumerKey = consumerKey;
		this.signatureSecret = new SharedConsumerSecretImpl(signatureSecret);
		this.authorities = ImmutableList.copyOf(authorities);
	}

	public String getConsumerName() {
		return consumerName;
	}

	public String getConsumerKey() {
		return consumerKey;
	}

	public SignatureSecret getSignatureSecret() {
		return signatureSecret;
	}

	public List<GrantedAuthority> getAuthorities() {
		return authorities;
	}
}
