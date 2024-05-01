package com.anuj.springboot.cruddemo.dao;

import com.anuj.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;

    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Employee findEmployee = entityManager.find(Employee.class, theId);
        return findEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee updatedEmployee = entityManager.merge(theEmployee);
        return updatedEmployee;
    }

    @Override
    public void delete(int theId) {
        Employee findEmployee = entityManager.find(Employee.class, theId);
        entityManager.remove(findEmployee);
    }
}
