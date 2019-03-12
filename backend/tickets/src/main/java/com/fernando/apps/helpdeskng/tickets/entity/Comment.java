package com.fernando.apps.helpdeskng.tickets.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Comment
 */
@Entity
@Table(name="commentsByTicket")
public class Comment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private long userId;
    private long ticketId;
    /*@ManyToOne(cascade = CascadeType.ALL)
    /@JoinColumn(name = "userId",insertable=false,updatable=false)
    private User user;*/
    private String comment;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticketId",insertable=false,updatable=false)
    private Ticket ticket;
    private Date cretedDate;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the ticketId
     */
    public Long getTicketId() {
        return ticketId;
    }

    /**
     * @param ticketId the ticketId to set
     */
    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
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

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    
    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the ticket
     */
    public Ticket getTicket() {
        return ticket;
    }

    /**
     * @param ticket the ticket to set
     */
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    /**
     * @return the cretedDate
     */
    public Date getCretedDate() {
        return cretedDate;
    }

    /**
     * @param cretedDate the cretedDate to set
     */
    public void setCretedDate(Date cretedDate) {
        this.cretedDate = cretedDate;
    }
}