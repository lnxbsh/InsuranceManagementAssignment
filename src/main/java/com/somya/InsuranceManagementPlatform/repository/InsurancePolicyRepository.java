package com.somya.InsuranceManagementPlatform.repository;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.somya.InsuranceManagementPlatform.model.InsurancePolicyEntity;


@Configurable
@Repository
public interface InsurancePolicyRepository  extends JpaRepository<InsurancePolicyEntity,Long>{
    
}
