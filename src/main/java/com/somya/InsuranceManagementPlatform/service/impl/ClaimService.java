package com.somya.InsuranceManagementPlatform.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somya.InsuranceManagementPlatform.model.ClaimEntity;
import com.somya.InsuranceManagementPlatform.model.InsurancePolicyEntity;
import com.somya.InsuranceManagementPlatform.repository.ClaimRepository;
import com.somya.InsuranceManagementPlatform.repository.InsurancePolicyRepository;
import com.somya.InsuranceManagementPlatform.service.ClaimServiceInterface;

@Service
public class ClaimService implements ClaimServiceInterface {

    @Autowired
    private ClaimRepository claimRepository;
    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;

    @Override
    public ClaimEntity saveClaimEntity(ClaimEntity claimEntity, long policy_id) {
      //  try {
            Set<ClaimEntity> claimEntities = null;
            InsurancePolicyEntity insurancePolicyEntity = insurancePolicyRepository.findById(policy_id).orElse(null);
            claimEntities = insurancePolicyEntity.getClaimsEntities();
            claimEntities.add(claimEntity);
            claimEntity.setInsurancePolicyEntity(insurancePolicyEntity);
            
            insurancePolicyEntity.setClaimsEntities(claimEntities);
            claimRepository.save(claimEntity);
            //insurancePolicyRepository.save(insurancePolicyEntity);
            return claimEntity;


    //    } catch (Exception e) {
            // TODO: handle exception
            
  //      }
//        throw new UnsupportedOperationException("Unimplemented method 'saveClaimEntity'");
    }

    @Override
    public List<ClaimEntity> getAllClaimEntity() {
        return claimRepository.findAll();
    }

    @Override
    public ClaimEntity getClaimEntity(long id) {
        // TODO Auto-generated method stub
        return claimRepository.findById(id).orElse(null);
        //throw new UnsupportedOperationException("Unimplemented method 'getClaimEntity'");
    }

    @Override
    public ClaimEntity updateClaimEntity(ClaimEntity claimEntity, long id) {
    
        ClaimEntity exisitClaimEntity = claimRepository.findById(id).orElse(claimEntity);
        exisitClaimEntity.setDescription(claimEntity.getDescription());
        exisitClaimEntity.setClaimDate(claimEntity.getClaimDate());
        exisitClaimEntity.setClaimStatus(claimEntity.getClaimStatus());
        claimRepository.save(exisitClaimEntity);
        return exisitClaimEntity;
        //throw new UnsupportedOperationException("Unimplemented method 'updateClaimEntity'");
    }

    @Override
    public ClaimEntity deleteClaimEntity(long id) {
        Set<ClaimEntity> claimEntities = null;
        ClaimEntity claimEntity = claimRepository.findById(id).orElse(null);
        InsurancePolicyEntity insurancePolicyEntity = insurancePolicyRepository.findById(claimEntity.getInsurancePolicyEntity().getPolicyNumber()).orElse(null);
        claimEntities = insurancePolicyEntity.getClaimsEntities();
        claimEntities.remove(claimEntity);
        claimEntity.setInsurancePolicyEntity(insurancePolicyEntity);
        
        insurancePolicyEntity.setClaimsEntities(claimEntities);
        claimRepository.delete(claimEntity);
        return claimEntity;
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'deleteClaimEntity'");
    }
    
}
