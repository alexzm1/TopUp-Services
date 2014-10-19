/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topup.services.user.domain.model;

/**
 * 
 * <b>UserProfile</b>
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 *
 */
public class UserProfile {

	private final String id;
	private final String phoneNumber;
	private final boolean status;

	/**
	 * <b>Constructor</b>
	 *
	 * @param id
	 * @param phoneNumber
	 * @param status
	 */
	public UserProfile(String id, String phoneNumber, boolean status) {
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

}
