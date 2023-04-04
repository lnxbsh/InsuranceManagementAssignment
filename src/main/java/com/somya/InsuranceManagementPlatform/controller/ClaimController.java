package com.somya.InsuranceManagementPlatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.somya.InsuranceManagementPlatform.AdapterPolicy;
import com.somya.InsuranceManagementPlatform.model.ClaimEntity;
import com.somya.InsuranceManagementPlatform.repository.ClaimRepository;
import com.somya.InsuranceManagementPlatform.service.impl.ClaimService;

import jakarta.annotation.Generated;

@Configurable
@RestController
@RequestMapping("/api/claims")
public class ClaimController {
    
    @Autowired
    private ClaimService claimService;

    @PostMapping()
    public ResponseEntity<ClaimEntity> saveClaim(@RequestBody AdapterPolicy adapterPolicy) {
        ClaimEntity claimEntity = adapterPolicy.getClaimEntity();
        claimService.saveClaimEntity(claimEntity, adapterPolicy.getPolicy_id());
        return new ResponseEntity<>(claimEntity, HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<List<ClaimEntity>> getAllClaims(){
        return new ResponseEntity<List<ClaimEntity>>(claimService.getAllClaimEntity(), HttpStatus.OK);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<ClaimEntity> getClaims(@PathVariable("id") long id){
        return new ResponseEntity<ClaimEntity>(claimService.getClaimEntity(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<ClaimEntity> updateClaim(@RequestBody ClaimEntity claimEntity, @PathVariable("id") long id){
        return new ResponseEntity<ClaimEntity>(claimService.updateClaimEntity(claimEntity, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ClaimEntity> deleteClaim(@PathVariable("id") long id){
        return new ResponseEntity<>(claimService.deleteClaimEntity(id),HttpStatus.GONE);
    }
}
