package com.topup.services.telephone.transform;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.topup.services.common.repository.MobileNumber;
import com.topup.services.telephone.domain.model.MobileStatus;

/**
 * 
 * <b>MobileNumberToMobileTransformerTest</b>
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 *
 */
public class MobileNumberToMobileTransformerTest {

	private MobileNumberToMobileTransformer mobileNumberToMobileTransformer = new MobileNumberToMobileTransformer();

	@Test
	public void testStatusActive() {

		MobileNumber mobileNumber = new MobileNumber();
		mobileNumber.setNumber("8046789719");
		mobileNumber.setStatus(MobileStatus.ACTIVE.toString());

		assertEquals(MobileStatus.ACTIVE, mobileNumberToMobileTransformer
				.transform(mobileNumber).getStatus());

	}

	@Test
	public void testStatusInvalid() {

		MobileNumber mobileNumber = new MobileNumber();
		mobileNumber.setNumber("8046789719");

		assertEquals(MobileStatus.INVALID, mobileNumberToMobileTransformer
				.transform(mobileNumber).getStatus());

	}
}
