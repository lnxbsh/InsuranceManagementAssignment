package com.somya.InsuranceManagementPlatform.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "insurance_policy")
public class InsurancePolicyEntity {
    
    @Setter @Getter
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long policyNumber;
    
    
    @Setter @Getter
    @Column(name = "type")
    private String type;

    @Setter @Getter
    @Column(name = "coverage_amount")
    private float converageAmount;

    @Setter @Getter
    @Column(name = "premium_amount")
    private float premiumAmount;

    @Setter @Getter
    @Column(name = "start_date")
    private Date startDate;

    @Setter @Getter
    @Column(name = "end_date")
    private Date endDate;

    @Getter @Setter
    @OneToOne(fetch = FetchType.LAZY, optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer"})
    private ClientEntity clientEntity;

    @Getter @Setter
    @OneToMany(targetEntity = ClaimEntity.class,cascade = CascadeType.REMOVE, orphanRemoval = true)
    //@JsonIgnoreProperties({"hibernateLazyInitializer"})
    //@JsonIgnore
    
    private Set<ClaimEntity> claimsEntities = new HashSet<>();
    

    public InsurancePolicyEntity(){}

    public InsurancePolicyEntity(String type, float converageAmount, float premiumAmount, Date startDate, Date endDate){
        this.type = type;
        this.converageAmount = converageAmount;
        this.premiumAmount = premiumAmount;
        this.startDate =  startDate;
        this.endDate = endDate;

    }




}
