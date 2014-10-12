package com.topup.services.security.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * <b>TokenRepository</b>
 *
 * @author alexzm1
 * @version 1.1
 * @since 1.1
 *
 */
public interface TokenRepository extends MongoRepository<Token, String> {

	/**
	 * 
	 * @param id
	 * @return
	 */
	List<Token> findById(String id);

}
