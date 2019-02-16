/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topup.services.telephone.service;

import com.topup.services.common.exception.MobileNumberInactiveException;
import com.topup.services.common.exception.MobileNumberInvalidException;
import com.topup.services.common.exception.MobileNumberNotFoundException;
import com.topup.services.common.repository.MobileNumber;
import com.topup.services.common.repository.MobileNumbersRepository;
import com.topup.services.common.translate.Transformer;
import com.topup.services.telephone.domain.model.AddBalanceRequest;
import com.topup.services.telephone.domain.model.Mobile;
import com.topup.services.telephone.domain.model.MobileStatus;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * <b>AccountServiceImplTest</b>
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 */
@ExtendWith(MockitoExtension.class)
public class AccountServiceImplTest {

    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private MobileNumbersRepository mobileNumberRepository;

    @Mock
    private Transformer<MobileNumber, Mobile> mobileNumberToMobileTransformer;

    @Mock
    private MongoTemplate template;

    @BeforeEach
    public void setup() {

        when(mobileNumberRepository.findByNumber(anyString())).thenAnswer(
                (Answer) invocationOnMock -> {
                    var mobileNumberArg = invocationOnMock.getArguments()[0].toString();
                    if (StringUtils.isEmpty(mobileNumberArg) || "8046789722".equals(mobileNumberArg)) {
                        return new ArrayList<MobileNumber>();
                    }

                    var mobileNumber = new MobileNumber();
                    mobileNumber.setNumber(mobileNumberArg);
                    mobileNumber.setBalance(BigDecimal.ZERO);
                    if (mobileNumberArg.startsWith("804")) {
                        mobileNumber.setStatus(MobileStatus.ACTIVE.toString());
                    } else if (mobileNumberArg.startsWith("803")) {
                        mobileNumber.setStatus(MobileStatus.INVALID.toString());
                    } else if (mobileNumberArg.startsWith("224")) {
                        mobileNumber.setStatus(MobileStatus.INACTIVE.toString());
                    }
                    return List.of(mobileNumber);
                }
        );
    }

    @ParameterizedTest
    @MethodSource("getMobileByNumberSource")
    public void getMobileByNumberTest(String mobileNumber, MobileStatus status) {

        if (!MobileStatus.NO_REGISTER.equals(status)) {
            when(mobileNumberToMobileTransformer.transform(any(MobileNumber.class)))
                    .thenAnswer(
                            (Answer) invocationOnMock -> {
                                var mobileNumberArg = (MobileNumber) invocationOnMock.getArguments()[0];
                                return new Mobile(mobileNumberArg.getNumber(), MobileStatus
                                        .valueOf(mobileNumberArg.getStatus()));
                            });
        }
        assertEquals(status, accountService.getMobileByNumber(mobileNumber).getStatus());

        if (MobileStatus.NO_REGISTER.equals(status)) {
            verify(mobileNumberToMobileTransformer, never()).transform(any(MobileNumber.class));
        } else {
            verify(mobileNumberToMobileTransformer, times(1)).transform(any(MobileNumber.class));
        }
    }

    @ParameterizedTest
    @MethodSource("addBalanceSource")
    public void addBalanceTest(String number, Class<Exception> exceptionType) {
        var request = new AddBalanceRequest();
        request.setMobileNumber(number);
        request.setAmount(BigDecimal.valueOf(5));

        if (exceptionType == null) {
            accountService.addBalance(request);
            verify(template, times(1)).save(any(MobileNumber.class));
        } else {
            assertThrows(exceptionType, () -> accountService.addBalance(request));
        }
        verify(mobileNumberRepository, times(1)).findByNumber(number);
    }

    private static Stream getMobileByNumberSource() {
        return Stream.of(
                Arguments.of("8046789719", MobileStatus.ACTIVE),
                Arguments.of("8046789722", MobileStatus.NO_REGISTER)
        );
    }

    private static Stream addBalanceSource() {
        return Stream.of(
                Arguments.of("8046789722", MobileNumberNotFoundException.class),
                Arguments.of("8038685521", MobileNumberInvalidException.class),
                Arguments.of("2245678890", MobileNumberInactiveException.class),
                Arguments.of("8047842167", null)
        );
    }

}
