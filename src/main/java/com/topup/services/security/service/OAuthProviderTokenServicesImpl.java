package com.topup.services.security.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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

	// TODO: Autowire this and made it final
	private TokenRepository tokenRepository;

	private final Transformer<Token, OAuthProviderTokenImpl> tokenToOAuthProviderTokenImplTransformer;

	private final Transformer<OAuthProviderTokenImpl, Token> oAuthProviderTokenImplToTokenTransformer;

	/**
	 * <b>Constructor</b>
	 *
	 * @param tokenRepository
	 */
	@Autowired
	public OAuthProviderTokenServicesImpl(
			TokenRepository tokenRepository,
			Transformer<Token, OAuthProviderTokenImpl> tokenToOAuthProviderTokenImplTransformer,
			Transformer<OAuthProviderTokenImpl, Token> oAuthProviderTokenImplToTokenTransformer) {
		// this.tokenRepository = tokenRepository;
		this.tokenToOAuthProviderTokenImplTransformer = tokenToOAuthProviderTokenImplTransformer;
		this.oAuthProviderTokenImplToTokenTransformer = oAuthProviderTokenImplToTokenTransformer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Cacheable(value = "tokens", key = "#token")
	protected OAuthProviderTokenImpl readToken(String token) {
		final Token tokenEntity = tokenRepository.findById(token).get(0);
		final OAuthProviderTokenImpl oAuthToken = tokenToOAuthProviderTokenImplTransformer
				.transform(tokenEntity);
		if (tokenEntity.isAccessToken
				&& !StringUtils.isEmpty(tokenEntity.getUserName())) {

			// TODO: Bring Authentication Principal and add it to the oAuthToken
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

		tokenRepository.save(oAuthProviderTokenImplToTokenTransformer
				.transform(token));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@CacheEvict(value = "token", key = "#tokenValue")
	protected OAuthProviderTokenImpl removeToken(String tokenValue) {
		final OAuthProviderTokenImpl token = readToken(tokenValue);
		tokenRepository.delete(tokenValue);
		return token;
	}

}
