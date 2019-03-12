package com.fernando.apps.helpdeskng.tickets.entity;

import java.io.Serializable;


/**
 * Organization
 */

public class Organization {
    Long id;
    String name;
    public Organization(){}

    public Organization(String name){
        this.name=name;
    }
    
}