package com.anuj.cruddemo.dao;

import com.anuj.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
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
}
