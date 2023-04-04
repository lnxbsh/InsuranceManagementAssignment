package com.somya.InsuranceManagementPlatform.service;

import java.util.List;

import com.somya.InsuranceManagementPlatform.model.InsurancePolicyEntity;

public interface InsurancePolicyServiceInterface {
    InsurancePolicyEntity saveInsurancePolicyEntity(InsurancePolicyEntity insurancePolicyEntity, long client_id);
    InsurancePolicyEntity updateInsurancePolicyEntity(InsurancePolicyEntity insurancePolicyEntity,long id);
    List<InsurancePolicyEntity> getAllInsurancePolicyEntity();
    InsurancePolicyEntity getInsurancePolicyEntity(long id);
    InsurancePolicyEntity deleteInsurancePolicyEntity(long id);
    
}
