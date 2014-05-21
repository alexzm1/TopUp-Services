package com.topup.services.telephone.translator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.topup.services.common.repository.MobileNumber;
import com.topup.services.telephone.domain.model.Mobile.Status;

public class MobileNumberToMobileTranslatorTest {

	private MobileNumberToMobileTranslator mobileNumberToMobileTranslator = new MobileNumberToMobileTranslator();

	@Test
	public void testStatusActive() {

		MobileNumber mobileNumber = new MobileNumber();
		mobileNumber.setNumber("8046789719");
		mobileNumber.setStatus(Status.ACTIVE.toString());

		assertEquals(Status.ACTIVE,
				mobileNumberToMobileTranslator.translate(mobileNumber)
						.getStatus());

	}

	@Test
	public void testStatusInvalid() {

		MobileNumber mobileNumber = new MobileNumber();
		mobileNumber.setNumber("8046789719");

		assertEquals(Status.INVALID,
				mobileNumberToMobileTranslator.translate(mobileNumber)
						.getStatus());

	}
}
