package se.iths.customexception;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;


public class ErrorMessageJson {
    int errorCode;
    LocalDateTime localDateTime = LocalDateTime.now();
    String message;
    String url;

    public ErrorMessageJson(int errorCode, String message, String url) {
        this.errorCode = errorCode;
        this.message = message;
        this.url = url;
    }


    public static Response getAll(){
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new ErrorMessageJson(404,"Students not found","api/v1/students"))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

    public static Response getByLastName(String lastName){
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new ErrorMessageJson(404,"Student with lastname: " + lastName + " does not exist", "api/v1/students"))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

    public static Response getById(Long id){
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new ErrorMessageJson(404, "Student with id: " + id + " not found","api/v1/students/" + id))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

}
