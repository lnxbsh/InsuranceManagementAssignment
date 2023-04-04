package com.somya.InsuranceManagementPlatform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.somya.InsuranceManagementPlatform.model.ClientEntity;
import com.somya.InsuranceManagementPlatform.repository.ClientRepository;
import com.somya.InsuranceManagementPlatform.service.ClientServiceInterface;

import lombok.Getter;
import lombok.Setter;

@Configurable
@Service
public class ClientService implements ClientServiceInterface {
    
    

    @Autowired
    private ClientRepository clientRepository;

   
    @Override
    public ClientEntity saveClientEntity(ClientEntity clientEntity){
    
        clientRepository.save(clientEntity);
        return clientEntity;
    }
    @Override
    public ClientEntity updateClientEntity(ClientEntity clientEntity,long id){
        ClientEntity existclientEntity = clientRepository.findById(id).orElse(clientEntity);
        existclientEntity.setName(clientEntity.getName());
        existclientEntity.setAddress(clientEntity.getAddress());
        existclientEntity.setContact(clientEntity.getContact());
        existclientEntity.setDob(clientEntity.getDob());
        clientRepository.save(clientEntity);
        return existclientEntity;
    }
    
    @Override
    public List<ClientEntity> getAllClientEntity(){
        List<ClientEntity> clients = clientRepository.findAll();
        return clients;
    }
    @Override
    public ClientEntity getClientEntity(long id) {
        ClientEntity exisitClient = clientRepository.findById(id).orElse(null);
        return exisitClient;
    }
    @Override
    public ClientEntity deleteClientEntity(long id){
        ClientEntity exisitClient = clientRepository.findById(id).orElse(null);
        clientRepository.deleteById(id);
        return exisitClient;
    }
    
    
    
}
