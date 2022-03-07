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
    @JoinTable(name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    private List<Student> studentList = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;

    public Subject() {
    }

    public Subject(String name) {
        this.name = name;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
        teacher.addOnlySubject(this);
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent(Student student){
        studentList.add(student);
        student.addOnlySubject(this);
    }

    public void addOnlyStudent(Student student) {
        studentList.add(student);
    }
}
