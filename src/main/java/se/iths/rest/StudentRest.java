package se.iths.rest;


import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("student")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class StudentRest {

    private final StudentService service;

    @Inject
    public StudentRest(StudentService service){
        this.service = service;
    }
    @Path("{id}")
    @GET
    public Response get(){
        return Response.ok().build();
    }

    @Path("getAll")
    @GET
    public Response getAll(){
        return Response.ok().build();
    }

    @Path("{id}")
    @GET
    public Response update(){
        return Response.ok().build();
    }

    @Path("create")
    @POST
    public Response create(){
        return Response.ok().build();
    }
}
