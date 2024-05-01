package com.anuj.cruddemo.dao;

import com.anuj.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentImpl implements StudentDAO{

    //define field for Entity Manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection

    public StudentImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by firstName asc", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastname(String lastname) {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where lastName=:theData", Student.class);
        theQuery.setParameter("theData",lastname);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Student stdinfo = entityManager.find(Student.class, id);
        entityManager.remove(stdinfo);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int result = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return result;
    }


}
