package com.fernando.apps.helpdeskng.users.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

/**
 * User
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User {

    Long id;
    String name;
    Long role;
    Date createdDate;
    public User(){}

    public User(Long id, String name, Long role){
        this.id=id;
        this.name=name;
        this.role=role;
        this.createdDate=new Date();
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

    /**
     * @return the role
     */
    public Long getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(Long role) {
        this.role = role;
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


}