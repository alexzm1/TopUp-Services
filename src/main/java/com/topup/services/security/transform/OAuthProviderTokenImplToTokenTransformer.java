package com.topup.services.security.transform;

import org.springframework.security.oauth.provider.token.OAuthProviderTokenImpl;
import org.springframework.stereotype.Component;

import com.topup.services.common.transform.Transformer;
import com.topup.services.security.repository.Token;

/**
 * <b>OAuthProviderTokenImplToTokenTransformer</b>
 *
 * @author alexzm1
 * @version 1.1
 * @since 1.1
 *
 */
@Component
public class OAuthProviderTokenImplToTokenTransformer implements
		Transformer<OAuthProviderTokenImpl, Token> {

	/** {@inheritDoc} **/
	@Override
	public Token transform(OAuthProviderTokenImpl token) {
		final Token tokenEntity = new Token();
		tokenEntity.setId(token.getValue());
		tokenEntity.setConsumerKey(token.getConsumerKey());
		tokenEntity.setVerifier(token.getVerifier());
		if (token.getUserAuthentication() != null) {
			tokenEntity.setUserName(token.getUserAuthentication().getName());
		}
		tokenEntity.setConsumerKey(token.getSecret());
		tokenEntity.setTimestamp(token.getTimestamp());
		tokenEntity.setAccessToken(token.isAccessToken());

		return tokenEntity;
	}

}
