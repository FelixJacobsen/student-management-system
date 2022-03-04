package se.iths.service;


import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.sql.rowset.spi.TransactionalWriter;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TeacherService {

    @PersistenceContext
    EntityManager entityManager;

    public void createTeacher(Teacher teacher){
        entityManager.persist(teacher);
    }

    public void deleteTeacher(Long id){
        Teacher teacher = entityManager.find(Teacher.class,id);
        entityManager.remove(teacher);
    }

    public List<Teacher> getAllTeachers(){
        TypedQuery<Teacher> findAll = entityManager.createQuery("SELECT t FROM Teacher t", Teacher.class);
        return findAll.getResultList();
    }

    public void updateTeacher(Teacher teacher){
        entityManager.merge(teacher);
    }

    public Teacher findById(Long id){
       return entityManager.find(Teacher.class, id);
    }


    public List<Teacher> findByName(String name){
        TypedQuery<Teacher> q = entityManager.createNamedQuery("Teacher.findByName", Teacher.class);
        return q.getResultList();
    }
    
}
