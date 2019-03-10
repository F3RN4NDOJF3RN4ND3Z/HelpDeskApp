package com.fernando.apps.helpdeskng.tickets.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Ticket
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Ticket {

    Long id;
    String description;
    Long category;
    Long organization;
    Long status;
    Long createdBy;
    Date createdDate;
    Date updatedDate;

    public Ticket (){}

    public Ticket(Long id, String description, Long category, Long organization , Long createdBy){
        this.id=id;
        this.description=description;
        this.category=category;
        this.organization=organization;
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
    public Long getCategory() {
        return category;
    }

    /**
     * @param catagory the catagory to set
     */
    public void setCatagory(Long category) {
        this.category = category;
    }

    /**
     * @return the organization
     */
    public Long getOrganization() {
        return organization;
    }

    /**
     * @param organization the organization to set
     */
    public void setOrganization(Long organization) {
        this.organization = organization;
    }

    /**
     * @return the status
     */
    public Long getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Long status) {
        this.status = status;
    }

    /**
     * @return the createdBy
     */
    public Long getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
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