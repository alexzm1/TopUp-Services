package com.topup.services.security.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * <b>UserResource</b>
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 *
 */
@RestController
@RequestMapping("/api/user")
public class UserResource {

	private final FilterChainProxy proxy;

	@Autowired
	public UserResource(FilterChainProxy proxy) {
		this.proxy = proxy;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String login() {
		return proxy.toString();
	}

	/**
	 * Returns the user profile for authenticated users
	 * 
	 * @return Instance of
	 *         {@link com.topup.services.user.domain.model.UserProfile}
	 */
	@PreAuthorize("hasRole('ROLE_DUMMY')")
	@RequestMapping(method = RequestMethod.GET, value = "/")
	@ResponseStatus(HttpStatus.OK)
	public Object getProfile(@AuthenticationPrincipal Object object) {
		return object;
	}

}