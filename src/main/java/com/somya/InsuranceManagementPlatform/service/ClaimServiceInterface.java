package com.somya.InsuranceManagementPlatform.service;

import java.util.List;

import com.somya.InsuranceManagementPlatform.model.ClaimEntity;

public interface ClaimServiceInterface {
    ClaimEntity saveClaimEntity(ClaimEntity claimEntity, long policy_id);
    List<ClaimEntity> getAllClaimEntity();
    ClaimEntity getClaimEntity(long id);
    ClaimEntity updateClaimEntity(ClaimEntity claimEntity,long id);
    ClaimEntity deleteClaimEntity(long id);
}
