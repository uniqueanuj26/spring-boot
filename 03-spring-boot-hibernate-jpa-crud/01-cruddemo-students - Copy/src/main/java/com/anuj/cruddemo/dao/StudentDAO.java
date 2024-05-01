package com.anuj.cruddemo.dao;

import com.anuj.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastname(String lastname);

    void update(Student theStudent);

    void  delete(int id);

    int deleteAll();
}
