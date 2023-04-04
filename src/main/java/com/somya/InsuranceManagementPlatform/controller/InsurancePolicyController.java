package com.somya.InsuranceManagementPlatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.somya.InsuranceManagementPlatform.Adapter;
import com.somya.InsuranceManagementPlatform.model.InsurancePolicyEntity;
import com.somya.InsuranceManagementPlatform.service.impl.InsurancePolicyService;

import jakarta.annotation.Generated;
import jakarta.websocket.server.PathParam;

@RequestMapping("/api/policies")
@RestController
public class InsurancePolicyController {

    @Autowired
    InsurancePolicyService insurancePolicyService;

    
    InsurancePolicyEntity insurancePolicyEntity;

    @GetMapping()
    ResponseEntity<List<InsurancePolicyEntity>> getAllInsurancePolicy(){
        return new ResponseEntity<>(insurancePolicyService.getAllInsurancePolicyEntity(),HttpStatus.OK);
    }

    @GetMapping("{id}")
    ResponseEntity<InsurancePolicyEntity> getInsurancePolicy(@PathVariable("id") long id){
        return new ResponseEntity<>(insurancePolicyService.getInsurancePolicyEntity(id),HttpStatus.OK);
    }


    @PostMapping()
    ResponseEntity<InsurancePolicyEntity> saveInsurancePolicy(@RequestBody Adapter adapter){
        insurancePolicyEntity = adapter.getInsurancePolicyEntity();     
        return new ResponseEntity<>(insurancePolicyService.saveInsurancePolicyEntity(insurancePolicyEntity,adapter.getClient_id()),HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    ResponseEntity<InsurancePolicyEntity> updateInsurancePolicy(@RequestBody InsurancePolicyEntity insurancePolicyEntity, @PathVariable("id") long id){
        return new ResponseEntity<>(insurancePolicyService.updateInsurancePolicyEntity(insurancePolicyEntity, id),HttpStatus.OK);   

    }

    @DeleteMapping("{id}")
    ResponseEntity<InsurancePolicyEntity> deleteInsurancePolicy(@PathVariable("id") long id){
        return new ResponseEntity<>(insurancePolicyService.deleteInsurancePolicyEntity(id),HttpStatus.GONE);    
    }
    
}
 