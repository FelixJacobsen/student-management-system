package se.iths.controller;


import se.iths.customexception.ErrorMessageJson;
import se.iths.customexception.StudentException;
import se.iths.entity.PhoneNumber;
import se.iths.entity.Student;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Path("students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentController {


    @Inject
    private StudentService service;

    @Path("")
    @POST
    public Response create(Student student, @Context UriInfo uriInfo) {
        try {
            service.createStudent(student);
        } catch (RuntimeException e) {
            System.out.println("Error creating student");
        }
        UriBuilder uriBuilder = uriInfo.getBaseUriBuilder().path(Long.toString(student.getId()));
        return Response.ok(uriBuilder.build()).build();
    }


    @Path("{id}")
    @GET
    public Response getStudent(@PathParam("id") Long id) {
        var studentById = service.findById(id);
        if (studentById == null)
            throw new StudentException(ErrorMessageJson.getById(id));
        return Response.ok(studentById).build();
    }


    @Path("")
    @GET
    public Response getAllStudents() {
        List<Student> allStudents = service.getAllStudents();
        if (allStudents.isEmpty())
            throw new StudentException(ErrorMessageJson.getAll());
        return Response.ok(allStudents).build();
    }


    @Path("{id}")
    @PUT
    public Response updateStudent(@PathParam("id") Long id, Student student, @Context UriInfo uriInfo) {
        service.updateStudent(student, id);
        URI uri = uriInfo.getBaseUriBuilder().path("students/" + id.toString()).build();
        return Response.created(uri).entity(student).build();
    }

    @Path("/search")
    @GET
    public Response getByLastName(@QueryParam("lastName") String lastName) {
        List<Student> foundStudents = service.findByLastName(lastName);
        if (foundStudents.isEmpty()) {
            throw new StudentException(ErrorMessageJson.getByLastName(lastName));
        }
        return Response.ok(foundStudents).build();
    }


    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id) {
        service.deleteStudent(id);
        return Response.ok().build();
    }

    @Path("{id}")
    @PATCH
    public Response updatePhoneNumber(@PathParam("id") Long id, PhoneNumber phoneNumber) {
        service.updatePhoneNumber(id, phoneNumber);
        return Response.ok(phoneNumber).build();

    }


}
