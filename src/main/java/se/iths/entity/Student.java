package se.iths.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity

public class Student {

    @Id
    private Long id;


    private String firstName;
    @NotEmpty(message = "Cannot be empty")
    @Size(min = 2, max = 30,message = "Must be minimum two and maximum 30 symbols")

    @NotEmpty(message = "Cannot be empty")
    @Size(min = 2, max = 30,message = "Must be minimum two and maximum 30 symbols")
    private String lastName;

    @Email(regexp = " ")
    @NotEmpty(message = "Cannot be empty")
    private String email;


    private String phoneNumber;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
