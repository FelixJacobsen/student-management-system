package se.iths.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    private Teacher teacher;

    @ManyToMany
    List<Student> studentList = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public Subject setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Subject setName(String name) {
        this.name = name;
        return this;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Subject setTeacher(Teacher teacher) {
        this.teacher = teacher;
        return this;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public Subject setStudentList(List<Student> studentList) {
        this.studentList = studentList;
        return this;
    }
}
