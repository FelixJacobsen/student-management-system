package se.iths.controller;


import se.iths.customexception.ErrorMessageJson;
import se.iths.customexception.StudentException;
import se.iths.entity.Student;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
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
        try{
            service.createStudent(student);
        }catch (Exception e){
            System.out.println("Find exception here");
        }
        UriBuilder uriBuilder = uriInfo.getBaseUriBuilder().path(Long.toString(student.getId()));
        return Response.ok(uriBuilder.build()).build();
    }


    @Path("{id}")
    @GET
    public Response getStudent(@PathParam("id") Long id) {
        var getById = service.findById(id);
        if (getById == null)
            throw new StudentException(ErrorMessageJson.getById(id));
        return Response.ok(getById).build();
    }


    @Path("")
    @GET
    public Response getAllStudents() {
        List<Student> allStudents = service.getAllStudents();
        if(allStudents.isEmpty())
            throw new StudentException(ErrorMessageJson.getAll());
        return Response.ok(allStudents).build();
    }



    @Path("{id}")
    @PUT
    public Response updateStudent(@PathParam("id") Long id, Student student) {
        service.updateStudent(student,id);
        return Response.ok(student).build();
    }

    @Path("/search")
    @GET
    public Response getByLastName(@QueryParam("lastName") String lastName){
        List<Student> foundStudents = service.findByLastName(lastName);
        if(foundStudents.isEmpty()){
            throw new StudentException(ErrorMessageJson.getByLastName(lastName));
        }
        return Response.ok(foundStudents).build();
    }


    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id){
        try{
            service.deleteStudent(id);
        }catch (IllegalArgumentException e){
            System.out.println("Student with id" + id + "does not exist");
        }
        return Response.ok().build();
    }



}
