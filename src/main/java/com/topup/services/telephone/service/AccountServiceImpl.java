/**
 * 
 */
package com.topup.services.telephone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.topup.services.common.exception.MobileNumberInactive;
import com.topup.services.common.exception.MobileNumberInvalid;
import com.topup.services.common.exception.MobileNumberNotFoundException;
import com.topup.services.common.repository.MobileNumber;
import com.topup.services.common.repository.MobileNumbersRepository;
import com.topup.services.common.translate.Transformer;
import com.topup.services.telephone.domain.model.AddBalanceRequest;
import com.topup.services.telephone.domain.model.Mobile;
import com.topup.services.telephone.domain.model.MobileStatus;

/**
 * 
 * <b>AccountServiceImpl</b>
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 *
 */
@Service
public class AccountServiceImpl implements AccountService {

	private final MongoTemplate template;
	private final MobileNumbersRepository mobileNumber;
	private final Transformer<MobileNumber, Mobile> mobileNumberToMobileTransformer;

	/**
	 * 
	 * <b>Constructor</b>
	 *
	 * @param mobileNumber
	 *            An instance of {@link MobileNumbersRepository}
	 * @param template
	 *            An instance of {@link MongoTemplate}
	 * @param mobileNumberToMobileTransformer
	 *            An instance of {@link Transformer<MobileNumber, Mobile>}
	 */
	@Autowired
	public AccountServiceImpl(
			final MobileNumbersRepository mobileNumber,
			final MongoTemplate template,
			@Qualifier("mobileNumberToMobileTransformer") final Transformer<MobileNumber, Mobile> mobileNumberToMobileTransformer) {
		this.mobileNumber = mobileNumber;
		this.template = template;
		this.mobileNumberToMobileTransformer = mobileNumberToMobileTransformer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addBalance(AddBalanceRequest request) {

		final List<MobileNumber> results = mobileNumber.findByNumber(request
				.getMobileNumber());

		if (results.isEmpty()) {

			throw new MobileNumberNotFoundException(request.getMobileNumber());
		}

		final MobileNumber mobileNumber = results.get(0);

		switch (MobileStatus.valueFromString(mobileNumber.getStatus())) {
		case ACTIVE:

			template.save(mobileNumber.addBalance(request.getAmount()));
			break;
		case INVALID:

			throw new MobileNumberInvalid(request.getMobileNumber());
		case INACTIVE:
		case NO_REGISTER:

			throw new MobileNumberInactive(request.getMobileNumber());

		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Mobile getMobileByNumber(String number) {
		final List<MobileNumber> results = mobileNumber.findByNumber(number);
		return results.isEmpty() ? new Mobile(number, MobileStatus.NO_REGISTER)
				: mobileNumberToMobileTransformer.transform(results.get(0));
	}
}
