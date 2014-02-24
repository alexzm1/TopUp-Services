/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.topup.services.user.service;

import com.topup.services.common.repository.MobileNumbers;
import com.topup.services.common.repository.MobileNumbersRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author Samuel Alejandro
 */
@Service
public class MobileNumberServiceImpl implements MobileNumberService {
    
    @Resource
    private MobileNumbersRepository mobileNumber;
    
    @Override
    public boolean getNumberStatus(String number) {
        List<MobileNumbers> results = mobileNumber.findByMobileNumber(number);
        
        return results.isEmpty() ? false : results.get(0).isStatus();
    }
    
}
