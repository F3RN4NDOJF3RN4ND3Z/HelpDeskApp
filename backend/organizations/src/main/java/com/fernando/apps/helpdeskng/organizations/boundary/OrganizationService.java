package com.fernando.apps.helpdeskng.organizations.boundary;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.Valid;

import com.fernando.apps.helpdeskng.organizations.entity.Organization;

/**
 * OrganizationService
 */
@Stateless
public class OrganizationService {
    @PersistenceContext EntityManager em;

    public Set<Organization> getAll(){
        List<Organization> list=em.createQuery("FROM Organizations o",Organization.class).getResultList();
        return new LinkedHashSet(list);
        
    }

    public Optional<Organization> get(Long id) {
        Organization found = em.find(Organization.class, id);
        return found != null ? Optional.of(found) : Optional.empty();
    }

    public void add(@Valid Organization newOrganization) {
        em.persist(newOrganization);
    }

    public boolean update(Organization updated){
        Organization found = em.find(Organization.class, updated.getId());
        if (found != null) {
            em.merge(updated);
            return true;
        }
        return false;
    }

    public void delete(Long id) {
        Query query = em.createQuery("DELETE FROM User u WHERE u.id = :id");
        query.setParameter("id", id)
                .executeUpdate();
    }


    
}