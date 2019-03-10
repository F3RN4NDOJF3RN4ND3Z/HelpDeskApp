package com.fernando.apps.helpdeskng.tickets.boundary;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * TicketService
 */
@Stateless
public class TicketService {
    @PersistenceContext EntityManager em;
    
}