package com.fernando.apps.helpdeskng.tickets.entity;

import java.util.Date;
import java.util.List;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Ticket
 */
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long categoryId;
    private Long organizationId;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryId",insertable=false,updatable=false)
    @Enumerated
    private Category category;
    @ManyToOne(cascade = CascadeType.ALL)
    /*@JoinColumn(name = "organizationId",insertable=false,updatable=false)
    private Organization organization;*/
    @Enumerated
    Status status;
    //@JsonbTransient
    @OneToMany(mappedBy = "ticket",cascade = CascadeType.ALL)
    @JoinColumn(name = "ticketId")
    private List<Comment> comments;
    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId",  insertable=false,updatable=false)
    User createdBy;*/
    Date createdDate;
    Date updatedDate;

    public Ticket() {
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

    /**
     * @return the categoryId
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Ticket(Long id, String description, Category category, Long organization, Long createdBy) {
        this.id=id;
        this.description=description;
        this.category=category;
        this.organizationId=organization;
        this.userId=createdBy;
        this.createdDate=new Date();
        //this.status="";

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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the catagory
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param catagory the catagory to set
     */
    public void setCatagory(Category category) {
        this.category = category;
    }

   

    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }


    /**
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return the updatedDate
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * @param updatedDate the updatedDate to set
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}