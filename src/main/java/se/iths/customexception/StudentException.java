package se.iths.customexception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class StudentException extends WebApplicationException {

    public StudentException(Response response) {
        super(Response.status(Response.Status.NOT_FOUND)
                .entity(new ErrorMessageJson(404,"No student found","api/v1/students"))
                .build());
    }


}
