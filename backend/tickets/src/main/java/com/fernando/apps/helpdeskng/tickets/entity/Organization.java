package com.fernando.apps.helpdeskng.tickets.entity;

import java.util.List;

import javax.annotation.Generated;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Organization
 */
@Entity
@Table(name="organizations")
public class Organization {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    String name;
    @JsonbTransient
    @OneToMany(mappedBy ="organizationId")
    List<Ticket> tickets;
    @JsonbTransient
    @OneToMany(mappedBy ="organizationId")
    List<User> users;
    public Organization(){}

    public Organization(String name){
        this.name=name;
    }
    
}