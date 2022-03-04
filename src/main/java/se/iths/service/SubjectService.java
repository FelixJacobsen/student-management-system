package se.iths.service;

import se.iths.entity.Subject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SubjectService {
    @PersistenceContext
    EntityManager entityManager;

    public void createSubject(Subject subject){
        entityManager.persist(subject);
    }

    public void deleteSubject(Long id) {
        Subject subject = entityManager.find(Subject.class, id);
        entityManager.remove(subject);
    }

    public List<Subject> getAllSubjects() {
        TypedQuery<Subject> findAll = entityManager.createQuery("SELECT s FROM Subject s", Subject.class);
        return findAll.getResultList();
    }


    public void updateSubject(Subject subject) {
        entityManager.merge(subject);
    }

    public Subject findById(Long id) {
        return entityManager.find(Subject.class, id);
    }


    public List<Subject> findByName(String name){
        TypedQuery<Subject> q = entityManager.createNamedQuery("Subject.findByName", Subject.class)
                .setParameter("name",name);
        return q.getResultList();
    }


}
