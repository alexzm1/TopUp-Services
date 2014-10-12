package com.topup.services.security.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth.provider.token.OAuthProviderTokenImpl;
import org.springframework.security.oauth.provider.token.OAuthProviderTokenServices;
import org.springframework.security.oauth.provider.token.RandomValueProviderTokenServices;

import com.topup.services.common.transform.Transformer;
import com.topup.services.security.repository.Token;
import com.topup.services.security.repository.TokenRepository;

/**
 * 
 * <b>OAuthProviderTokenServicesImpl</b>
 *
 * @author alexzm1
 * @version 1.1
 * @since 1.1
 *
 */
public class OAuthProviderTokenServicesImpl extends
		RandomValueProviderTokenServices implements OAuthProviderTokenServices {

	private final TokenRepository tokenRepository;

	private final Transformer<Token, OAuthProviderTokenImpl> tokenToOAuthProviderTokenImplTransformer;

	/**
	 * <b>Constructor</b>
	 *
	 * @param tokenRepository
	 */
	@Autowired
	public OAuthProviderTokenServicesImpl(
			TokenRepository tokenRepository,
			Transformer<Token, OAuthProviderTokenImpl> tokenToOAuthProviderTokenImplTransformer) {
		this.tokenRepository = tokenRepository;
		this.tokenToOAuthProviderTokenImplTransformer = tokenToOAuthProviderTokenImplTransformer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected OAuthProviderTokenImpl readToken(String token) {
		final Token tokenEntity = tokenRepository.findById(token).get(0);
		final OAuthProviderTokenImpl oAuthToken = tokenToOAuthProviderTokenImplTransformer
				.transform(tokenEntity);
		if (tokenEntity.isAccessToken
				&& !StringUtils.isEmpty(tokenEntity.getUserName())) {

			// TODO: Bing Authentication Principal and add it to the oAuthToken
			throw new UnsupportedOperationException(
					"Authentication Token not supported yet");
		}

		return oAuthToken;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void storeToken(String tokenValue, OAuthProviderTokenImpl token) {
		final Token tokenEntity = new Token();
		tokenEntity.setId(token.getValue());
		tokenEntity.setConsumerKey(token.getConsumerKey());
		tokenEntity.setVerifier(token.getVerifier());
		tokenEntity.setUserName(token.getUserAuthentication().getName());
		tokenEntity.setConsumerKey(token.getSecret());
		tokenEntity.setTimestamp(token.getTimestamp());
		tokenEntity.setAccessToken(token.isAccessToken());
		tokenRepository.save(tokenEntity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected OAuthProviderTokenImpl removeToken(String tokenValue) {
		final OAuthProviderTokenImpl token = readToken(tokenValue);
		tokenRepository.delete(tokenValue);
		return token;
	}

}
