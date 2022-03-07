package se.iths.entity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "Student.findById",
                query = "SELECT s FROM Student s WHERE s.id = :id"),
        @NamedQuery(
                name = "Student.findByLastName",
                query = "SELECT s FROM Student s WHERE s.lastName = :lastName")
})


public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Cannot be empty")
    @Size(min = 2, max = 30, message = "Must be minimum two and maximum 30 symbols")
    private String firstName;

    @NotEmpty(message = "Cannot be empty")
    @Size(min = 2, max = 30, message = "Must be minimum two and maximum 30 symbols")
    private String lastName;

    @NotEmpty(message = "Cannot be empty")
    private String email;

    @ManyToMany(mappedBy = "studentList", cascade = CascadeType.ALL)
    private List<Subject> subjectList = new ArrayList<>();

    private String phoneNumber;



    public Student(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Student(){}


    @JsonbTransient
    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public Student setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
        return this;
    }

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

    public void addSubject(Subject subject){
        subjectList.add(subject);
        subject.addOnlyStudent(this);
    }

    public void addOnlySubject(Subject subject){
       subjectList.add(subject);
    }



}
