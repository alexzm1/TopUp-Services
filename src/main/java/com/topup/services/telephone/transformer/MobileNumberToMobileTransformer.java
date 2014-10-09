package com.topup.services.telephone.transformer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.topup.services.common.repository.MobileNumber;
import com.topup.services.common.translate.Transformer;
import com.topup.services.telephone.domain.model.Mobile;
import com.topup.services.telephone.domain.model.MobileStatus;

/**
 * 
 * <b>MobileNumberToMobileTransformer</b>
 *
 * Transform an object of {@link MobileNumber} to an object of {@link Mobile}.
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 *
 */
@Component("mobileNumberToMobileTransformer")
public class MobileNumberToMobileTransformer implements
		Transformer<MobileNumber, Mobile> {

	private static final Map<String, MobileStatus> status = new HashMap<>();

	static {

		Arrays.stream(MobileStatus.values()).forEach(
				statusEntry -> status.put(statusEntry.toString(), statusEntry));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Mobile transform(MobileNumber mobileNumber) {
		return new Mobile(mobileNumber.getNumber(),
				MobileStatus.valueFromString(mobileNumber.getStatus()));
	}
}
