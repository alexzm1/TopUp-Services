/**
 * 
 */
package com.topup.services.security.transform;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.topup.services.security.domain.model.Authorities;
import com.topup.services.security.exception.InvalidUserRoleException;
import com.topup.services.security.service.SecurityFixture;

/**
 * <b>UserDetailToUserTransformerTest</b>
 *
 * @author alexzm1
 * @version 1.1
 * @since 1.1
 *
 */
public class UserDetailToUserTransformerTest {

	@Test
	public void transform_MobileRole() {
		final UserDetailToUserTransformer transformer = new UserDetailToUserTransformer();
		assertTrue(transformer
				.transform(
						SecurityFixture.createUserDetail("Test1", "12345",
								"8047894681", "MOBILE")).getAuthorities()
				.contains(Authorities.MOBILE_USER));
	}

	@Test
	public void transform_AdminRole() {
		final UserDetailToUserTransformer transformer = new UserDetailToUserTransformer();
		assertTrue(transformer
				.transform(
						SecurityFixture.createUserDetail("Test1", "12345",
								"8047894681", "ADMIN")).getAuthorities()
				.contains(Authorities.ADMIN_USER));
	}

	@Test(expected = InvalidUserRoleException.class)
	public void transform_InvalidRole() {
		final UserDetailToUserTransformer transformer = new UserDetailToUserTransformer();
		transformer.transform(SecurityFixture.createUserDetail("Test1",
				"12345", "8047894681", "###"));
		fail("InvalidUserRoleException not trown after sending an invalid role");
	}
}
