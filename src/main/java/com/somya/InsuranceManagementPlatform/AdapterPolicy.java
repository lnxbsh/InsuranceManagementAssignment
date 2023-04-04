package com.somya.InsuranceManagementPlatform;

import org.springframework.beans.factory.annotation.Autowired;

import com.somya.InsuranceManagementPlatform.model.ClaimEntity;

import lombok.Getter;
import lombok.Setter;

public class AdapterPolicy {

    @Setter @Getter
    @Autowired
    private ClaimEntity claimEntity;

    @Setter @Getter
    private long policy_id;
    
}
