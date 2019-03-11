package com.fernando.apps.helpdeskng.organizations.boundary;

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

import com.fernando.apps.helpdeskng.organizations.entity.Organization;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

/**
 * OrganizationsResource
 */
@Path("organizations")
@Api(value="/organizations")
public class OrganizationResource {

    @Inject
    private OrganizationService service;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") Long id){
        return Response.ok(service.get(id)).build();
    }
    @GET
    @ApiOperation(value = "Get all organizations")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        return Response.ok(service.getAll()).build();
    }

    @POST
    @ApiOperation(value = "Create an organization",notes = "This can only be done by and user.")
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid Organization input"),@ApiResponse(code = 201, message = "Organization added")})
    public Response add(@ApiParam(value = "Organization to be added", required = true)Organization organization,@Context UriInfo uriInfo){
        service.add(organization);
        return Response.created(getLocation(uriInfo, organization.getId())).build();
    }
    
    @PUT
    @Path("{id}")
    @ApiOperation(value = "Update Organization", response = Organization.class)
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Organization invalid input"),@ApiResponse(code = 404, message = "Organization not found"),@ApiResponse(code = 200, message = "Organization updated")})
    public Response update(@ApiParam(value = "ID of oragnization that needs to be updated",required = true) @PathParam("id") Long id,
    @ApiParam(value = "Organization that needs to be updated", required = true) Organization updated){
        updated.setId(id);
        boolean done = service.update(updated);

        return done
                ? Response.ok(updated).build()
                : Response.status(Response.Status.NOT_FOUND).build();

    }

    @DELETE
    @ApiOperation(value = "Remove the Organization")
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@ApiParam(value = "ID of organization that needs to be removed",required=true) @PathParam("id") Long id){
        service.delete(id);
        return Response.ok().build();
    }

    URI getLocation(UriInfo uriInfo, Long id) {
        return uriInfo.getAbsolutePathBuilder().path("" + id).build();
    }
}