package se.iths.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@NamedQuery(
        name = "Subject.findByName",
        query = "SELECT s FROM Subject s WHERE s.name = :name")

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String name;


    @ManyToMany
    @JoinTable(name = "",
            joinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    private List<Student> studentList = new ArrayList<>();


    @ManyToOne
    private Teacher teacher;

    public Subject() {
    }

    public Subject(String name) {
    }

    public void addStudent(Student student){
        studentList.add(student);
        student.addSubject(this);
    }


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
