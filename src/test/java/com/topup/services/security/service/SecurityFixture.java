package com.topup.services.security.service;

import com.topup.services.security.repository.Token;
import com.topup.services.security.repository.UserDetail;

/**
 * <b>SecurityFixture</b>
 *
 * @author alexzm1
 * @version 1.1
 * @since 1.1
 *
 */
public class SecurityFixture {

	/**
	 * Creates an instance of {@link UserDetail}
	 * 
	 * @param userName
	 * @param password
	 * @param phoneNumber
	 * @param role
	 * @return An instance of {@link UserDetail} containing the received
	 *         parameters in the method
	 */
	public static UserDetail createUserDetail(String userName, String password,
			String phoneNumber, String role) {
		final UserDetail user = new UserDetail();
		user.setUserName(userName);
		user.setPassword(password);
		user.setPhoneNumber(phoneNumber);
		user.setRole(role);

		return user;
	}

	/**
	 * Creates an instance of {@link Token}
	 * 
	 * @param id
	 * @param userName
	 * @param accessToken
	 * @return An instance of {@link Token}
	 */
	public static Token createToken(String id, String userName,
			boolean accessToken) {
		final Token token = new Token();
		token.setId(id);
		token.setSecret("278763");
		token.setAccessToken(accessToken);
		token.setVerifier("17652");
		token.setUserName(userName);
		token.setConsumerKey("4756543");
		token.setTimestamp(System.currentTimeMillis());

		return token;
	}
}
