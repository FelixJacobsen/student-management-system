package se.iths.util;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class ExampleData {

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void generateData() {

        Student student1 = new Student("Nils", "Eriksson",
                "nils.eriksson@student.se", "0701020304");
        Student student2 = new Student("Bertil", "Larsson",
                "bertil.larsson@student.se", "0701003234");
        Student student3 = new Student("Ylva", "Henriksson",
                "ylva.henriksson@student.se", "0777839483");


        Teacher teacher1 = new Teacher("Anders", "Nilsson");
        Teacher teacher2 = new Teacher("Lotta", "Svensson");


        Subject subject1 = new Subject("Java");
        Subject subject2 = new Subject("C++");
        Subject subject3 = new Subject("C#");
        Subject subject4 = new Subject("Python");
        Subject subject5 = new Subject("JavaScript");


        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);

        subject1.addStudent(student1);
        subject1.addStudent(student2);
        subject3.addStudent(student3);
        

        entityManager.persist(teacher1);
        entityManager.persist(teacher2);

        subject1.setTeacher(teacher1);
        subject2.setTeacher(teacher2);
        subject3.setTeacher(teacher2);

        entityManager.persist(subject1);
        entityManager.persist(subject2);
        entityManager.persist(subject3);
        entityManager.persist(subject4);
        entityManager.persist(subject5);
    }
}
