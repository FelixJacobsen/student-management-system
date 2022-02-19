package se.iths.customexception;

public class StudentExceptionMessage {
    private String exceptionMessage;
    private Long id;

    public StudentExceptionMessage(String exceptionMessage, Long id) {
        this.exceptionMessage = exceptionMessage;
        this.id = id;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
