package com.topup.services.security.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.security.Principal;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.oauth.provider.token.OAuthProviderTokenImpl;

import com.topup.services.common.transform.Transformer;
import com.topup.services.security.domain.model.Authorities;
import com.topup.services.security.repository.Token;
import com.topup.services.security.repository.TokenRepository;

/**
 * <b>OAuthProviderTokenServicesImplTest</b>
 *
 * @author alexzm1
 * @version 1.1
 * @since 1.1
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class OAuthProviderTokenServicesImplTest {

	@Mock
	private TokenRepository tokenRepository;

	@Mock
	private Transformer<Token, OAuthProviderTokenImpl> tokenToOAuthProviderTokenImplTransformer;

	@Mock
	private Transformer<OAuthProviderTokenImpl, Token> oAuthProviderTokenImplToTokenTransformer;

	private OAuthProviderTokenServicesImpl tokenService;

	@Before
	public void setUp() {
		when(tokenRepository.findById(Matchers.anyString())).thenReturn(
				Arrays.asList(SecurityFixture.createToken("74776", "Test",
						false)));
		when(
				tokenToOAuthProviderTokenImplTransformer.transform(Matchers
						.any(Token.class))).thenReturn(
				new OAuthProviderTokenImpl());
		when(
				oAuthProviderTokenImplToTokenTransformer.transform(Matchers
						.any(OAuthProviderTokenImpl.class))).thenReturn(
				new Token());
		tokenService = new OAuthProviderTokenServicesImpl(tokenRepository,
				tokenToOAuthProviderTokenImplTransformer,
				oAuthProviderTokenImplToTokenTransformer);
	}

	/**
	 * Test method for
	 * {@link com.topup.services.security.service.OAuthProviderTokenServicesImpl#readToken(java.lang.String)}
	 * .
	 */
	@Test
	public void testReadTokenString() {
		assertNotNull(tokenService.readToken("12345"));
	}

	/**
	 * Test method for
	 * {@link com.topup.services.security.service.OAuthProviderTokenServicesImpl#storeToken(java.lang.String, org.springframework.security.oauth.provider.token.OAuthProviderTokenImpl)}
	 * .
	 */
	@Test
	public void testStoreTokenStringOAuthProviderTokenImpl() {
		final OAuthProviderTokenImpl tokenProvider = new OAuthProviderTokenImpl();
		tokenProvider.setUserAuthentication(new AnonymousAuthenticationToken(
				"9865", Mockito.mock(Principal.class), Arrays
						.asList(Authorities.MOBILE_USER)));
		tokenService.storeToken("9865", tokenProvider);
	}

	/**
	 * Test method for
	 * {@link com.topup.services.security.service.OAuthProviderTokenServicesImpl#removeToken(java.lang.String)}
	 * .
	 */
	@Test
	public void testRemoveTokenString() {
		assertNotNull(tokenService.removeToken("12345"));
	}

}
