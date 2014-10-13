package com.topup.services.security.transform;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.topup.services.security.service.SecurityFixture;

/**
 * <b>TokenToOAuthProviderTokenImplTransformerTest</b>
 *
 * @author alexzm1
 * @version 1.1
 * @since 1.1
 *
 */
public class TokenToOAuthProviderTokenImplTransformerTest {

	/**
	 * Test method for
	 * {@link com.topup.services.security.transform.TokenToOAuthProviderTokenImplTransformer#transform(com.topup.services.security.repository.Token)}
	 * .
	 */
	@Test
	public void testTransform() {
		final TokenToOAuthProviderTokenImplTransformer transformer = new TokenToOAuthProviderTokenImplTransformer();
		assertNotNull(transformer.transform(SecurityFixture.createToken("1",
				"alexzm1", true)));
	}

}
