/**
 * 
 */
package com.topup.services.telephone.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.topup.services.common.repository.MobileNumber;
import com.topup.services.common.repository.MobileNumbersRepository;
import com.topup.services.common.translate.Translator;
import com.topup.services.telephone.domain.model.AddBalanceRequest;
import com.topup.services.telephone.domain.model.Mobile;
import com.topup.services.telephone.domain.model.Mobile.Status;

/**
 * @author alexzm1
 *
 */
@Service
public class AccountServiceImpl implements AccountService {

	private final MongoTemplate template;
	private final MobileNumbersRepository mobileNumber;
	private final Translator<MobileNumber, Mobile> mobileNumberToMobileTranslator;

	@Autowired
	public AccountServiceImpl(
			final MobileNumbersRepository mobileNumber,
			final MongoTemplate template,
			@Qualifier("mobileNumberToMobileTranslator") final Translator<MobileNumber, Mobile> mobileNumberToMobileTranslator) {
		this.mobileNumber = mobileNumber;
		this.template = template;
		this.mobileNumberToMobileTranslator = mobileNumberToMobileTranslator;
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

		List<MobileNumber> results = mobileNumber.findByNumber(request
				.getMobileNumber());

		if (!results.isEmpty()) {

			MobileNumber result = results.get(0);
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
	 * com.topup.services.telephone.service.AccountService#getMobileByNumber
	 * (java.lang.String)
	 */
	@Override
	public Mobile getMobileByNumber(String number) {
		List<MobileNumber> results = mobileNumber.findByNumber(number);
		if (results.isEmpty()) {
			Mobile mobile = new Mobile();
			mobile.setNumber(number);
			mobile.setStatus(Status.NO_REGISTER);

			return mobile;
		} else {

			return mobileNumberToMobileTranslator.translate(results.get(0));
		}
	}
}
