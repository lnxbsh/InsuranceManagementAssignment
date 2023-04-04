package com.somya.InsuranceManagementPlatform.service;

import java.util.List;

import com.somya.InsuranceManagementPlatform.model.ClientEntity;

public interface ClientServiceInterface {
    ClientEntity saveClientEntity(ClientEntity clientEntity);
    ClientEntity updateClientEntity(ClientEntity clientEntity,long id);
    List<ClientEntity> getAllClientEntity();
    ClientEntity getClientEntity(long id);
    ClientEntity deleteClientEntity(long id);
}
