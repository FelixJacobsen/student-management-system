package se.iths.controller;

import se.iths.entity.Teacher;
import se.iths.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("teachers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherController {

    @Inject
    TeacherService teacherService;

    @Path("")
    @POST
    public Response createTeacher(Teacher teacher, @Context UriInfo uriInfo){
         teacherService.createTeacher(teacher);
        UriBuilder uriBuilder = uriInfo.getBaseUriBuilder().path(Long.toString(teacher.getId()));
        return Response.ok(uriBuilder.build()).build();
    }


    @Path("")
    @GET
    public Response getAllTeachers(){
        List<Teacher> teacherList = teacherService.getAllTeachers();
        return Response.ok(teacherList).build();
    }

    @Path("{id}")
    @GET
    public Response getById(@PathParam("id") Long id){
        Teacher foundTeacher = teacherService.findById(id);
        return Response.ok(foundTeacher).build();
    }

    @Path("/search")
    public Response getByLastName(@QueryParam("lastName") String lastName){
        List<Teacher> foundTeacher = teacherService.findByLastName(lastName);
        return Response.ok(foundTeacher).build();
    }
}
