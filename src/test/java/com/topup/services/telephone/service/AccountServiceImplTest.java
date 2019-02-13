/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topup.services.telephone.service;

import com.topup.services.common.repository.MobileNumber;
import com.topup.services.common.repository.MobileNumbersRepository;
import com.topup.services.common.translate.Transformer;
import com.topup.services.telephone.domain.model.Mobile;
import com.topup.services.telephone.domain.model.MobileStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * <b>AccountServiceImplTest</b>
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {

    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private MobileNumbersRepository mobileNumberRepository;

    @Mock
    private Transformer<MobileNumber, Mobile> mobileNumberToMobileTransformer;

    @Before
    public void setup() {

        MobileNumber mobileNumberActive = new MobileNumber();
        mobileNumberActive.setNumber("8046789719");
        mobileNumberActive.setStatus(MobileStatus.ACTIVE.toString());

        when(mobileNumberRepository.findByNumber("8046789719")).thenReturn(
                Arrays.asList(mobileNumberActive));

        when(mobileNumberToMobileTransformer.transform(mobileNumberActive))
                .thenReturn(
                        new Mobile(mobileNumberActive.getNumber(), MobileStatus
                                .valueOf(mobileNumberActive.getStatus())));

        when(mobileNumberRepository.findByNumber("8046789722")).thenReturn(
                new ArrayList<MobileNumber>());

    }

    @Test
    public void testValidNumber() {
        assertEquals(MobileStatus.ACTIVE,
                accountService.getMobileByNumber("8046789719").getStatus());
    }

    @Test
    public void testNoRegisterNumber() {
        assertEquals(MobileStatus.NO_REGISTER, accountService
                .getMobileByNumber("8046789722").getStatus());
    }

}
