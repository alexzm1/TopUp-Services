/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.topup.services.common.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 
 * <b>MobileNumbersRepository</b>
 *
 * Mobile Number mongo's repository
 * 
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 *
 */
public interface MobileNumbersRepository extends
		MongoRepository<MobileNumber, String> {

	/**
	 * Find a list of MobileNumbers from a mobile number
	 * 
	 * @param number
	 *            Number
	 * @return A List of MobileNumber
	 */
	List<MobileNumber> findByNumber(String number);

}
