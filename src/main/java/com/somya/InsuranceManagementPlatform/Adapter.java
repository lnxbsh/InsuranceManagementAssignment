package com.somya.InsuranceManagementPlatform;

import org.springframework.beans.factory.annotation.Autowired;

import com.somya.InsuranceManagementPlatform.model.InsurancePolicyEntity;

import lombok.Getter;
import lombok.Setter;

public class Adapter {
    
    @Getter @Setter
    @Autowired
    private InsurancePolicyEntity insurancePolicyEntity;
    
    @Getter @Setter
    private long client_id;



}
