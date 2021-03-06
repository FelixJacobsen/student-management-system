package se.iths.service;

import se.iths.entity.StudentPhoneNumber;
import se.iths.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    public void createStudent(Student student) {
        entityManager.persist(student);
    }

    public void deleteStudent(Long id) {
        Student deletedStudent = entityManager.find(Student.class, id);
        entityManager.remove(deletedStudent);
    }

    public List<Student> getAllStudents() {
        TypedQuery<Student> findAll = entityManager.createQuery("SELECT s FROM Student s", Student.class);
        return findAll.getResultList();
    }


    public void updateStudent(Student newStudent, Long id) {
        Student updateStudent = findById(id);
        if (updateStudent != null) {
            updateStudentProperties(newStudent, updateStudent);
        }
        entityManager.merge(newStudent);
    }

    private void updateStudentProperties(Student newStudent, Student updateStudent) {
        updateStudent.setFirstName(newStudent.getFirstName());
        updateStudent.setLastName(newStudent.getLastName());
        updateStudent.setEmail(newStudent.getEmail());
        updateStudent.setPhoneNumber(newStudent.getPhoneNumber());
    }

    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }


    public List<Student> findByLastName(String lastName){
        TypedQuery<Student> searchLastName = entityManager.createNamedQuery("Student.findByLastName", Student.class)
                .setParameter("lastName",lastName);
        return searchLastName.getResultList();
    }

    public void updatePhoneNumber(Long id, StudentPhoneNumber phoneNumber){
        Student newNumber = findById(id);
        newNumber.setPhoneNumber(phoneNumber.getPhoneNumber());
        entityManager.merge(newNumber);
    }
}
