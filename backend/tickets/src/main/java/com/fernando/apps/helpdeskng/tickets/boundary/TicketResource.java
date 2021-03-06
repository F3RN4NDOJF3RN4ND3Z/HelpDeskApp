package com.fernando.apps.helpdeskng.tickets.boundary;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.fernando.apps.helpdeskng.tickets.entity.Ticket;



/**
 * TicketsResource
 */
@Path("tickets")
public class TicketResource {

    @Inject
    TicketService service;
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("{id}")
    public Response get(@PathParam("id") Long id){
        return Response.ok(service.get(id)).build();
    
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        return Response.ok(service.getAll()).build();
    }

    @POST
    public Response add(Ticket ticket,@Context UriInfo uriInfo){
        service.add(ticket);
        return Response.created(getLocation(uriInfo, ticket.getId())).build();

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

    URI getLocation(UriInfo uriInfo, Long id) {
        System.out.println("generando url");
        return uriInfo.getAbsolutePathBuilder().path("" + id).build();
    }
    
}