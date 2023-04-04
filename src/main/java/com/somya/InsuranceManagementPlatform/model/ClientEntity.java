package com.somya.InsuranceManagementPlatform.model;


import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "clients")
public class ClientEntity {
    
    @Setter @Getter
    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "contact")
	private int contact;

    @Column(name = "dob")
    private Date dob;
    
    // @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // private InsurancePolicyEntity insurancePolicyEntity;

    public ClientEntity(){

    }

    public ClientEntity(String name, String address, int contact, Date dob){
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.dob = dob;
    }

    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }

    public int getContact(){
        return contact;
    }
    public void setContact(int contact){
        this.contact = contact;
    }

    public Date getDob(){
        return dob;
    }
    public void setDob(Date dob){
        this.dob = dob;
    }


}

