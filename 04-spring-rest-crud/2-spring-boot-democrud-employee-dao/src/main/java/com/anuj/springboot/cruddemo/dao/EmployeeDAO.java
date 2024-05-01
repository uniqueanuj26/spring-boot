package com.anuj.springboot.cruddemo.dao;

import com.anuj.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void delete(int theId);
}
