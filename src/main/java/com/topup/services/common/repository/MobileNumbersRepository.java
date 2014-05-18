/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.topup.services.common.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Mobile Number mongo's repository
 *
 * @author alexzm1
 */
public interface MobileNumbersRepository extends
		MongoRepository<MobileNumbers, String> {

	/**
	 * Find a list of MobileNumbers from a mobile number
	 * 
	 * @param mobileNumber
	 *            Mobile Number
	 * @return A List of MobileNumber
	 */
	List<MobileNumbers> findByMobileNumber(String mobileNumber);

}
