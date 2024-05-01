package com.anuj.springboot.cruddemo.rest;

import com.anuj.springboot.cruddemo.dao.EmployeeDAO;
import com.anuj.springboot.cruddemo.entity.Employee;
import com.anuj.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    /*private EmployeeDAO employeeDAO;
    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    } */
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        //List<Employee> employees = employeeDAO.findAll();
        //return employees;
        return  employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
       Employee theEmployee = employeeService.findById(employeeId);
       if(theEmployee == null){
           throw new RuntimeException("Employee not found:"+employeeId);
       }
       return  theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        theEmployee.setId(0); //incase use pass id in json, this treat as new record and set new id.
        Employee dbEmployee = employeeService.save(theEmployee);
        return  dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        return employeeService.save(theEmployee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
       Employee dbEmployee = employeeService.findById(employeeId);
       if(dbEmployee == null){
           throw new RuntimeException("Employee not found with ID:"+ employeeId);
       }
       employeeService.delete(employeeId);
       return "Employee deleted ID:" + employeeId;

    }
}
