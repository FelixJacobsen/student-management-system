package se.iths.rest;


import se.iths.customexception.StudentException;
import se.iths.entity.Student;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    private final StudentService service;

    @Inject
    public StudentRest(StudentService service) {
        this.service = service;
    }

    

    @Path("{id}")
    @GET
    public Response getStudent(@PathParam("id") Long id) {
        var getById = service.findById(id);
        if (getById == null)
            throw new StudentException(id);

        return Response.ok(getById).build();
    }

    @Path("")
    @GET
    public Response getAllStudents() {
        List<Student> allStudents = service.getAllStudents();
        return Response.ok(allStudents).build();
    }



   /* @Path("create")
    @POST
    public Response create(Student student) {
        return Response.ok().build();
    }


    @Path("{id}")
    @GET
    public Response update() {
        return Response.ok().build();
    }*/


}
