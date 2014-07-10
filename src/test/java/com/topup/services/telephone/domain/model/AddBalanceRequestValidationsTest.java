package com.topup.services.telephone.domain.model;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Before;
import org.junit.Test;

public class AddBalanceRequestValidationsTest {

	private Validator validator;

	@Before
	public void setUp() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();

	}

	@Test
	public void testAmountNull() {
		final AddBalanceRequest request = createTestRequest();
		final Set<ConstraintViolation<AddBalanceRequest>> violations = validator
				.validate(request);
		assertEquals(1, violations.size());
	}

	private static AddBalanceRequest createTestRequest() {
		final AddBalanceRequest addBalanceRequest = new AddBalanceRequest();
		addBalanceRequest.setAmount(10);
		addBalanceRequest.setMobileNumber("1234567890");
		addBalanceRequest.setCreditCard(createTestCreditCardRequest());

		return addBalanceRequest;
	}

	private static CreditCardRequest createTestCreditCardRequest() {
		final CreditCardRequest request = new CreditCardRequest();
		request.setCcv("111");
		request.setExpirationMonth("10");
		request.setExpirationYear("2020");
		request.setNumber("4111111111111111");

		return request;
	}

}
