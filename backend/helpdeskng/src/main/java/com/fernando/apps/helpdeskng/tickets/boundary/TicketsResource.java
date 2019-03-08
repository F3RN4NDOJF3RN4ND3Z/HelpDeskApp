package com.fernando.apps.helpdeskng.tickets.boundary;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;



/**
 * TicketsResource
 */
@Path("tickets")
public class TicketsResource {

    @GET
    public Response get(){
        return Response.ok("tickets works").build();
    }
    
}