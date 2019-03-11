package com.fernando.apps.helpdeskng.organizations.boundary;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.annotation.PostConstruct;;

/**
 * SeedData
 */
@Singleton
@Startup
public class SeedData {

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void init(){

    }
    
}