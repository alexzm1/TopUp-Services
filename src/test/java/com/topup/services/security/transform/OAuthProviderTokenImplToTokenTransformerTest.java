/**
 * 
 */
package com.topup.services.security.transform;

import static org.junit.Assert.assertNotNull;

import java.security.Principal;
import java.util.Arrays;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.oauth.provider.token.OAuthProviderTokenImpl;

import com.topup.services.security.domain.model.Authorities;

/**
 * <b>OAuthProviderTokenImplToTokenTransformerTest</b>
 *
 * @author alexzm1
 * @version
 * @since
 *
 */
public class OAuthProviderTokenImplToTokenTransformerTest {

	/**
	 * Test method for
	 * {@link com.topup.services.security.transform.OAuthProviderTokenImplToTokenTransformer#transform(org.springframework.security.oauth.provider.token.OAuthProviderTokenImpl)}
	 * .
	 */
	@Test
	public void testTransform() {
		final OAuthProviderTokenImpl tokenProvider = new OAuthProviderTokenImpl();
		tokenProvider.setUserAuthentication(new AnonymousAuthenticationToken(
				"9865", Mockito.mock(Principal.class), Arrays
						.asList(Authorities.MOBILE_USER)));

		final OAuthProviderTokenImplToTokenTransformer transformer = new OAuthProviderTokenImplToTokenTransformer();
		assertNotNull(transformer.transform(tokenProvider));
	}

}
