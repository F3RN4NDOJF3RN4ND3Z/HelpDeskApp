package com.fernando.apps.helpdeskng.organizations.boundary;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * OrganizationsResource
 */
@Path("organizations")
public class OrganizationsResource {

    @GET
    public Response get(){
        return Response.ok("organizations works").build();
    }
    
}