package com.fernando.apps.helpdeskng.tickets.entity;

import java.io.Serializable;



/**
 * User
 */

public class User {
    private Long id;
    private String name;
    private Long organizationId;
    /*@JsonbTransient
    @OneToMany(mappedBy = "createdBy")
    private List<Ticket> tickets;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organizationId",insertable=false,updatable=false)
    private Organization organization;*/

    public User() {
    }

    /**
     * @return the organizationId
     */
    public Long getOrganizationId() {
        return organizationId;
    }

    /**
     * @param organizationId the organizationId to set
     */
    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public User(Long id, String name) {
        this.id=id;
        this.name=name;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

  


    
}