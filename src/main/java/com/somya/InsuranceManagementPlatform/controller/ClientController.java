package com.somya.InsuranceManagementPlatform.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.RepaintManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

import com.somya.InsuranceManagementPlatform.model.ClientEntity;
import com.somya.InsuranceManagementPlatform.service.impl.ClientService;


@RestController
@RequestMapping("/api/clients")
public class ClientController {
    
    @Autowired
    private ClientService clientService;
    
    @GetMapping()
    ResponseEntity<List<ClientEntity>> getAllClient(){
        List<ClientEntity> clients = new ArrayList<ClientEntity>();
        clients = clientService.getAllClientEntity();
        return new ResponseEntity<>(clients,HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<ClientEntity> addClient(@RequestBody ClientEntity clientEntity){
        clientService.saveClientEntity(clientEntity);
        return new ResponseEntity<ClientEntity>(clientEntity,HttpStatus.OK);
    }

    @GetMapping("{id}")
    ResponseEntity<ClientEntity> fetchClient(@PathVariable("id") long id){
        return new ResponseEntity<ClientEntity>(clientService.getClientEntity(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    ResponseEntity<ClientEntity> updateClient(@PathVariable("id") long id, @RequestBody ClientEntity clientEntity){
        return new ResponseEntity<ClientEntity>(clientService.updateClientEntity(clientEntity, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    ResponseEntity<ClientEntity> deleteClient(@PathVariable("id") long id){
        ClientEntity clientEntity = clientService.deleteClientEntity(id);
        return new ResponseEntity<ClientEntity>(clientEntity, HttpStatus.GONE); 
    }
    
}
