package com.topup.services.security.transform;

import org.springframework.security.oauth.provider.token.OAuthProviderTokenImpl;
import org.springframework.stereotype.Component;

import com.topup.services.common.transform.Transformer;
import com.topup.services.security.repository.Token;

/**
 * <b>TokenToOAuthProviderTokenImplTransformer</b>
 *
 * @author alexzm1
 * @version 1.1
 * @since 1.1
 *
 */
@Component
public class TokenToOAuthProviderTokenImplTransformer implements
		Transformer<Token, OAuthProviderTokenImpl> {

	/** {@inheritDoc} **/
	@Override
	public OAuthProviderTokenImpl transform(Token token) {
		final OAuthProviderTokenImpl oauthToken = new OAuthProviderTokenImpl();
		oauthToken.setValue(token.getId());
		oauthToken.setConsumerKey(token.getConsumerKey());
		oauthToken.setSecret(token.getSecret());
		oauthToken.setTimestamp(token.getTimestamp());
		oauthToken.setVerifier(token.getVerifier());
		oauthToken.setAccessToken(token.isAccessToken);
		return oauthToken;
	}

}
