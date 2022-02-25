package se.iths.customexception;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.stream.Collectors;

@Provider
public class ConstraintException implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException constraintViolationException) {
        var exceptions = constraintViolationException.getConstraintViolations()
                .stream()
                .map(this::validator)
                .collect(Collectors.toList());

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(exceptions)
                .build();
    }

    private ConstraintExceptionProperties validator(ConstraintViolation<?> constraintViolation) {
        ConstraintExceptionProperties message = new ConstraintExceptionProperties();
        message.setMessage(constraintViolation.getMessage());
        message.setField(constraintViolation.getPropertyPath().toString());
        return message;
    }
}
