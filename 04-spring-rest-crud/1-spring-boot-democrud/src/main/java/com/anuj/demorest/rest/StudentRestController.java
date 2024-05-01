package com.anuj.demorest.rest;

import com.anuj.demorest.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    public List<Student> loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Anuj","Thapa"));
        theStudents.add(new Student("Krishna","Yenni"));
        theStudents.add(new Student("Akanksha","Thapa"));
        return theStudents;
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
      return theStudents;
    }


    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if((studentId < 0) || (studentId >= theStudents.size())){
            throw new StudentNotFoundException("Student id not found - "+ studentId);
        }
        return  theStudents.get(studentId);
    }


}
