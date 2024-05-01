package com.anuj.demorest.rest;

import com.anuj.demorest.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api1")
public class DemoRestController {
    @GetMapping("/students")
    public List<Student> getStudentList(){

        List<Student> std = new ArrayList<>();
        std.add(new Student("anuj","thapa"));
        std.add(new Student("sanuj","thapa"));
        std.add(new Student("akanksha","thapa"));
        return std;
    }
}
