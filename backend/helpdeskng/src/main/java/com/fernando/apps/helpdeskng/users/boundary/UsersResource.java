package com.fernando.apps.helpdeskng.users.boundary;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("users")
public class UsersResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {

        return Response.ok("user works").build();

    }

}