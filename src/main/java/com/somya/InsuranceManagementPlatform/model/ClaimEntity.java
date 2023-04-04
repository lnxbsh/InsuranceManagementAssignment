package com.somya.InsuranceManagementPlatform.model;

import java.sql.Date;

import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Configurable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "claims")
public class ClaimEntity {
    
    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long claimNumber;

    @Getter @Setter
    @Column(name = "description")
    private String description;


    @Getter @Setter
    @Column(name = "claim_date")
    private Date claimDate;

    @Getter @Setter
    @Column(name = " claim_status")
    private String  claimStatus;

    @Getter @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    //@JsonIgnore()
    //@JsonIgnoreProperties({"hibernateLazyInitializer"})
    // @JoinColumn(name = "policy_id", nullable = false)
    //@JsonProperty("Policy_Number")
    @JsonIncludeProperties("policyNumber")
    private InsurancePolicyEntity insurancePolicyEntity;


    public ClaimEntity(){}

    public ClaimEntity(String description, Date claimDate, String claimStatus){
        this.claimDate = claimDate;
        this.description = description;
        this.claimStatus = claimStatus;
    }
    
}
