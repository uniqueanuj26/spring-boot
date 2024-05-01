package com.anuj.springboot.cruddemo.service;

import com.anuj.springboot.cruddemo.dao.EmployeeRepository;
import com.anuj.springboot.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();

    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> theEmployee = employeeRepository.findById(theId);
        Employee result = null;
        if(theEmployee.isPresent()){
            result = theEmployee.get();
        }else{
            throw new RuntimeException("Employee ID not found:"+ theId);
        }
        return result;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void delete(int theId) {
        employeeRepository.deleteById(theId);
    }
}
