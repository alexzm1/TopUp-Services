package com.topup.services.security.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.topup.services.common.transform.Transformer;
import com.topup.services.security.domain.model.Authorities;
import com.topup.services.security.repository.UserDetail;
import com.topup.services.security.repository.UserDetailRepository;

/**
 * <b>UserDetailsServiceImplTest</b>
 *
 * @author alexzm1
 * @version 1.1
 * @since 1.1
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class UserDetailsServiceImplTest {

	@Mock
	private Transformer<UserDetail, User> userDetailToUserTransformer;

	@Mock
	private UserDetailRepository userDetailRepository;

	@Before
	public void setUp() {
		when(userDetailRepository.findByUserName(Matchers.anyString()))
				.thenReturn(
						Arrays.asList(SecurityFixture.createUserDetail("Test",
								"12345", "8048789410", "MOBILE")));
		when(
				userDetailToUserTransformer.transform(Matchers
						.any(UserDetail.class))).thenReturn(
				new User("Test", "12345", Arrays
						.asList(Authorities.MOBILE_USER)));
	}

	/**
	 * Test method for
	 * {@link com.topup.services.security.service.UserDetailsServiceImpl#loadUserByUsername(java.lang.String)}
	 * .
	 */
	@Test
	public void testLoadUserByUsername_Found() {
		assertNotNull(new UserDetailsServiceImpl(userDetailToUserTransformer,
				userDetailRepository).loadUserByUsername("Test"));
	}

	@Test(expected = UsernameNotFoundException.class)
	public void testLoadUserByUsername_NotFound() {
		when(userDetailRepository.findByUserName(Matchers.anyString()))
				.thenReturn(new ArrayList<>());
		new UserDetailsServiceImpl(userDetailToUserTransformer,
				userDetailRepository).loadUserByUsername("Test");
		fail("UserNotFoundException not thrown after getting an empty list of user");
	}

}
