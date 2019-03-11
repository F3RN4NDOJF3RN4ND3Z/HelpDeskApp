package com.fernando.apps.helpdeskng.users.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Organization
 */
@Entity
@Table(name  ="organizations")
public class Organization {

    Long id;
    String name;
}