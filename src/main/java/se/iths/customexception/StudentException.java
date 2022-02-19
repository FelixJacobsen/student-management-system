package se.iths.customexception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class StudentException extends WebApplicationException {

    public StudentException(Long id) {
        super(Response.status(Response.Status.NOT_FOUND)
                .entity(new StudentExceptionMessage("No student found,", id))
                .build());
    }


}
