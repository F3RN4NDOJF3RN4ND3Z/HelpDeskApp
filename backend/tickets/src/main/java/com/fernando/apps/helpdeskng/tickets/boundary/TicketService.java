package com.fernando.apps.helpdeskng.tickets.boundary;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Valid;

import com.fernando.apps.helpdeskng.tickets.entity.Ticket;

/**
 * TicketService
 */
@Stateless
public class TicketService {
    @PersistenceContext EntityManager em;
    
    public Set<Ticket> getAll(){
        List<Ticket> list=em.createQuery("FROM Organization o",Ticket.class).getResultList();
        return new LinkedHashSet(list);
    }

    public void add(@Valid Ticket newTicket){
        em.persist(newTicket);

    }

    public boolean updated(Ticket updated){
        Ticket found=em.find(Ticket.class,updated);
        if(found!=null){
            em.merge(updated);
            return true; 
        }
        return false;
    }

    public void remove(Long id){
        Query query=em.createQuery("DELETE FROM Ticket t WHERE t.id= :id");
        query.setParameter("id", id).executeUpdate();
    }

    public Optional<Ticket> get (Long id){
        Ticket ticket=em.find(Ticket.class,id);
        return ticket != null ? Optional.of(ticket) : Optional.empty();
    }
}