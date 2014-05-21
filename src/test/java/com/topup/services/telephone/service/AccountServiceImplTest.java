/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topup.services.telephone.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.topup.services.common.repository.MobileNumber;
import com.topup.services.common.repository.MobileNumbersRepository;
import com.topup.services.common.translate.Translator;
import com.topup.services.telephone.domain.model.Mobile;
import com.topup.services.telephone.domain.model.Mobile.Status;

/**
 *
 * @author alexzm1
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {

	@InjectMocks
	private AccountServiceImpl accountService;

	@Mock
	private MobileNumbersRepository mobileNumberRepository;

	@Mock
	private Translator<MobileNumber, Mobile> mobileNumberToMobileTranslator;

	@Before
	public void setup() {

		MobileNumber mobileNumberActive = new MobileNumber();
		mobileNumberActive.setNumber("8046789719");
		mobileNumberActive.setStatus(Status.ACTIVE.toString());

		when(mobileNumberRepository.findByNumber("8046789719")).thenReturn(
				Arrays.asList(mobileNumberActive));

		Mobile mobile = new Mobile();
		mobile.setNumber(mobileNumberActive.getNumber());
		mobile.setStatus(Status.valueOf(mobileNumberActive.getStatus()));

		when(mobileNumberToMobileTranslator.translate(mobileNumberActive))
				.thenReturn(mobile);

		when(mobileNumberRepository.findByNumber("8046789722")).thenReturn(
				new ArrayList<MobileNumber>());

	}

	@Test
	public void testValidNumber() {
		assertEquals(Status.ACTIVE,
				accountService.getMobileByNumber("8046789719").getStatus());
	}

	@Test
	public void testNoRegisterNumber() {
		assertEquals(Status.NO_REGISTER,
				accountService.getMobileByNumber("8046789722").getStatus());
	}

}
