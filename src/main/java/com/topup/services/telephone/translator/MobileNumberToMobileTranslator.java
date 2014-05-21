package com.topup.services.telephone.translator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.topup.services.common.repository.MobileNumber;
import com.topup.services.common.translate.Translator;
import com.topup.services.telephone.domain.model.Mobile;
import com.topup.services.telephone.domain.model.Mobile.Status;

/**
 * Translate an object of
 * {@link com.topup.services.common.repository.MobileNumber} to an object of
 * {@link com.topup.services.telephone.domain.model.Mobile}.
 * 
 * @author alexzm1
 *
 */
@Component("mobileNumberToMobileTranslator")
public class MobileNumberToMobileTranslator implements
		Translator<MobileNumber, Mobile> {

	private Map<String, Mobile.Status> status;

	public MobileNumberToMobileTranslator() {

		status = new HashMap<>();

		Arrays.stream(Mobile.Status.values()).forEach(
				statusEntry -> status.put(statusEntry.toString(), statusEntry));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.topup.services.common.translate.Translator#translate(java.lang.Object
	 * )
	 */
	@Override
	public Mobile translate(MobileNumber mobileNumber) {
		Mobile mobile = new Mobile();
		mobile.setNumber(mobileNumber.getNumber());
		if (!StringUtils.isEmpty(mobileNumber.getStatus())
				&& status.containsKey(mobileNumber.getStatus().toUpperCase())) {
			mobile.setStatus(status.get(mobileNumber.getStatus().toUpperCase()));
		} else {
			mobile.setStatus(Status.INVALID);
		}
		return mobile;
	}
}
