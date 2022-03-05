package se.iths.controller;

import se.iths.entity.Subject;
import se.iths.service.SubjectService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("subjects")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectController {
    @Inject
    SubjectService subjectService;

    @Path("")
    @POST
    public Response create(Subject subject, @Context UriInfo uriInfo) {
        subjectService.createSubject(subject);
        UriBuilder uriBuilder = uriInfo.getBaseUriBuilder().path(Long.toString(subject.getId()));
        return Response.ok(uriBuilder.build()).build();
    }

    @Path("")
    @GET
    public Response getAllSubjects() {
        List<Subject> allSubjects = subjectService.getAllSubjects();
        return Response.ok(allSubjects).build();
    }

    @Path("{id}")
    @GET
    public Response getById(@PathParam("id") Long id) {
        Subject foundSubject = subjectService.findById(id);
        return Response.ok(foundSubject).build();
    }

    @Path("{id}")
    @DELETE
    public Response removeResponse(@PathParam("id") Long id) {
        Subject foundSubject = subjectService.findById(id);
        subjectService.deleteSubject(foundSubject.getId());
        return Response.ok().build();
    }


}
