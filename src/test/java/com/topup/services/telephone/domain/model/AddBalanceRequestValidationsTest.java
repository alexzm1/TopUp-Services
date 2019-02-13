package com.topup.services.telephone.domain.model;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * <b>AddBalanceRequestValidationsTest</b>
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 */
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
        addBalanceRequest.setAmount(BigDecimal.TEN);
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
