/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.topup.services.common.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Samuel Alejandro
 */
public interface MobileNumbersRepository extends JpaRepository<MobileNumbers, String>{
    
    List<MobileNumbers> findByMobileNumber(String mobileNumber);
    
}
