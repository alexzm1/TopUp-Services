/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topup.services.user.service;

import com.topup.services.common.repository.MobileNumbers;
import static org.mockito.Mockito.when;

import com.topup.services.common.repository.MobileNumbersRepository;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Samuel Alejandro
 */
@RunWith(MockitoJUnitRunner.class)
public class MobileNumberServiceImplTest {

    @InjectMocks
    private MobileNumberServiceImpl mobileNumberService;

    @Mock
    private MobileNumbersRepository mobileNumberRepository;

    @Before
    public void setup() {
        
        List<MobileNumbers> mobileNumbers = new ArrayList<>();
        
        MobileNumbers mobileNumber = new MobileNumbers();
        mobileNumber.setMobileNumber("8046789719");
        mobileNumber.setStatus(true);
        
        mobileNumbers.add(mobileNumber);
        
        mobileNumber = new MobileNumbers();
        mobileNumber.setMobileNumber("8046789720");
        mobileNumber.setStatus(false);
        
        mobileNumbers.add(mobileNumber);
        
        when(mobileNumberRepository.findByMobileNumber(
                "8046789719")).thenReturn(mobileNumbers) ;
    }
    
    @Test
    public void testValidNumber(){
        assertTrue(mobileNumberService.getNumberStatus("8046789719"));
    }
    
    @Test
    public void testInvalidNumber(){
        assertFalse(mobileNumberService.getNumberStatus("8046789720"));
    }

}
