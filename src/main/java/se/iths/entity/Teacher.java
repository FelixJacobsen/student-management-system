package se.iths.entity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@NamedQuery(name = "Teacher.findByName",
            query = "SELECT t FROM Teacher t WHERE t.firstName = :firstName")
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(min = 2)
    private String firstName;

    @NotEmpty
    @Size(min = 2)
    private String lastName;


    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Subject> subjectList = new ArrayList<>();


    public Teacher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Teacher() {

    }


    public Long getId() {
        return id;
    }

    public Teacher setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Teacher setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Teacher setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }



    @JsonbTransient
    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public void addOnlySubject(Subject subject){
        subjectList.add(subject);
    }

    public void addSubject(Subject subject){
        subjectList.add(subject);
        subject.setTeacher(this);
    }

}
