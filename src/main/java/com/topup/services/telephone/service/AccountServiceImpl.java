/**
 * 
 */
package com.topup.services.telephone.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.topup.services.common.repository.MobileNumbers;
import com.topup.services.common.repository.MobileNumbersRepository;
import com.topup.services.telephone.model.AddBalanceRequest;

/**
 * @author alexzm1
 *
 */
@Service
public class AccountServiceImpl implements AccountService {

	private MongoTemplate template;

	private MobileNumbersRepository mobileNumber;

	@Autowired
	public AccountServiceImpl(MobileNumbersRepository mobileNumber,
			MongoTemplate template) {
		this.mobileNumber = mobileNumber;
		this.template = template;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.topup.services.telephone.service.AccountService#addBalance(com.topup
	 * .services.telephone.model.AddBalanceRequest)
	 */
	@Override
	public void addBalance(AddBalanceRequest request) {

		List<MobileNumbers> results = mobileNumber.findByMobileNumber(request
				.getMobileNumber());

		if (!results.isEmpty()) {
			
			MobileNumbers result = results.get(0);
			result.getBalance().add(
					BigDecimal.valueOf(Double.valueOf(request.getAmount())));
			template.save(result);
		} else {

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.topup.services.telephone.service.AccountService#getAccountStatus(
	 * java.lang.String)
	 */
	@Override
	public boolean getAccountStatus(String number) {
		List<MobileNumbers> results = mobileNumber.findByMobileNumber(number);

		return results.isEmpty() ? false : results.get(0).isStatus();
	}

}
