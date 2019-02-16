package com.topup.services.telephone.rest;

import com.topup.services.telephone.domain.model.AddBalanceRequest;
import com.topup.services.telephone.domain.model.Mobile;
import com.topup.services.telephone.domain.model.MobileStatus;
import com.topup.services.telephone.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
public class TelephoneResourceTest {

    private static final String mobileNumber = "8888888888";

    @InjectMocks
    private TelephoneResource resource;

    @Mock
    private AccountService service;

    @Test
    public void getMobileStatusTest() {
        when(service.getMobileByNumber(anyString())).thenAnswer(
                (Answer) invocationOnMock -> {
                    var mobileNumberArg = invocationOnMock.getArguments()[0].toString();
                    return new Mobile(mobileNumberArg, MobileStatus.ACTIVE);
                }
        );

        var response = resource.getMobileStatus(mobileNumber);
        assertEquals(mobileNumber, response.getNumber());
        assertEquals(MobileStatus.ACTIVE, response.getStatus());
        verify(service, times(1)).getMobileByNumber(anyString());
    }

    @Test
    public void addBalanceTest() {
        resource.addBalance(mobileNumber, new AddBalanceRequest());
        verify(service, times(1)).addBalance(any(AddBalanceRequest.class));
    }

}
