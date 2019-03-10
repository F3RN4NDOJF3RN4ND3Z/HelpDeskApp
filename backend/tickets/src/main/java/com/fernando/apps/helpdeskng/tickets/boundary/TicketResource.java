package com.fernando.apps.helpdeskng.tickets.boundary;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fernando.apps.helpdeskng.tickets.entity.Ticket;



/**
 * TicketsResource
 */
@Path("tickets")
public class TicketResource {

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("{id}")
    public Response get(@PathParam("id") Long id){
        return Response.ok("tickets works").build();
    
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        return Response.ok("get all works").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Ticket ticket){
        return Response.ok("add works").build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id){
        return Response.ok("update works").build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id){
        return Response.noContent().build();
    }
    
}