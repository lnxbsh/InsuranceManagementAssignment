package com.somya.InsuranceManagementPlatform.service.impl;

import java.util.List;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.somya.InsuranceManagementPlatform.Adapter;
import com.somya.InsuranceManagementPlatform.model.ClientEntity;
import com.somya.InsuranceManagementPlatform.model.InsurancePolicyEntity;
import com.somya.InsuranceManagementPlatform.repository.ClientRepository;
import com.somya.InsuranceManagementPlatform.repository.InsurancePolicyRepository;
import com.somya.InsuranceManagementPlatform.service.InsurancePolicyServiceInterface;


@Configurable
@Service
public class InsurancePolicyService implements InsurancePolicyServiceInterface {

    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;
    @Autowired
    private ClientRepository clientRepository;


    @Override
    public InsurancePolicyEntity saveInsurancePolicyEntity(InsurancePolicyEntity insurancePolicyEntity, long client_id) {
        ClientEntity clientEntity = clientRepository.findById(client_id).orElse(null);
        insurancePolicyEntity.setClientEntity(clientEntity);
        insurancePolicyRepository.save(insurancePolicyEntity);
        return insurancePolicyEntity;
    }

    @Override
    public InsurancePolicyEntity updateInsurancePolicyEntity(InsurancePolicyEntity insurancePolicyEntity, long id){
        InsurancePolicyEntity existInsuranceEntity = insurancePolicyRepository.findById(id).orElse(insurancePolicyEntity);
        if (existInsuranceEntity.getClientEntity().getId() == insurancePolicyEntity.getClientEntity().getId()){
            existInsuranceEntity.setClientEntity(insurancePolicyEntity.getClientEntity());
        } 
        
        existInsuranceEntity.setType(insurancePolicyEntity.getType());
        existInsuranceEntity.setConverageAmount(insurancePolicyEntity.getConverageAmount());
        existInsuranceEntity.setPremiumAmount(insurancePolicyEntity.getPremiumAmount());
        existInsuranceEntity.setStartDate(insurancePolicyEntity.getStartDate());
        existInsuranceEntity.setEndDate(insurancePolicyEntity.getEndDate());
        insurancePolicyRepository.save(existInsuranceEntity);
        return existInsuranceEntity;
    }
    
    @Override
    public List<InsurancePolicyEntity> getAllInsurancePolicyEntity(){
        List<InsurancePolicyEntity> insurancePolicyEntity = insurancePolicyRepository.findAll();
        return insurancePolicyEntity;
    }
    
    @Override
    public InsurancePolicyEntity getInsurancePolicyEntity(long id) {
        InsurancePolicyEntity insurancePolicyEntity = insurancePolicyRepository.findById(id).orElse(null);
        return insurancePolicyEntity;
    }
    @Override
    public InsurancePolicyEntity deleteInsurancePolicyEntity(long id) {
        InsurancePolicyEntity insurancePolicyEntity = insurancePolicyRepository.findById(id).orElse(null);
        insurancePolicyRepository.deleteById(id);
        return insurancePolicyEntity;
    }


    
}
