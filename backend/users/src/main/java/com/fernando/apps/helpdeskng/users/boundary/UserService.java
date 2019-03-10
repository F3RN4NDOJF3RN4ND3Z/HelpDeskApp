package com.fernando.apps.helpdeskng.users.boundary;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * UserService
 */
@Stateless
public class UserService {
    @PersistenceContext EntityManager em;
    
}