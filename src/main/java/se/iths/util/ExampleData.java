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
    public void createExampleData(){

        Teacher teacherAnders = new Teacher("Anders","Nilsson",
                "anders.nilsson@gmail.com","0705030201");
        Teacher teacherLotta = new Teacher("Lotta","Svensson",
                "lotta.svensson@gmail.com", "0703020103");



        Student studentNils = new Student("Nils", "Eriksson",
                "nils.eriksson@student.se","0701020304");
        Student studentBertil = new Student("Bertil", "Larsson",
                "bertil.larsson@student.se","0701003234");
        Student studentYlva = new Student("Ylva", "Henriksson",
                "ylva.henriksson@student.se","0777839483");



        Subject subjectJava = new Subject("Java");
        Subject subjectCPlusPlus = new Subject("C++");
        Subject subjectCSHarp = new Subject("C#");
        Subject subjectPython = new Subject("Python");
        Subject subjectJavaScript = new Subject("JavaScript");

        teacherAnders.addSubject(subjectJava);
        teacherAnders.addSubject(subjectCPlusPlus);

        studentNils.addSubject(subjectJava);
        studentBertil.addSubject(subjectPython);
        studentYlva.addSubject(subjectCSHarp);
        studentYlva.addSubject(subjectJavaScript);

        entityManager.persist(teacherAnders);
        entityManager.persist(studentNils);
        entityManager.persist(studentBertil);
        entityManager.persist(studentYlva);
    }
}
