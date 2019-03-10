package com.fernando.apps.helpdeskng.users.boundary;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import com.fernando.apps.helpdeskng.users.entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@Path("users")
@Api(value = "/users")
public class UserResource {

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response get(@PathParam("id") Long id) {

        return Response.ok("user works").build();

    }

    @GET
    @ApiOperation(value = "Get all users",
    notes = "This can only be done by the logged in user.")
    @ApiResponses(value = {
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "User not found") 
    })
    public Response getAll(){
        return Response.ok("get all works").build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(User user){
        return Response.ok("add works").build();
    }

    @DELETE
    @Path("{id}")
    public Response update(@PathParam("id") Long id){
        return Response.ok("update works").build();
    }

    public Response delete(Long id){
        return Response.noContent().build();
    }

}