package com.anuj.springcoredemo.rest;

import com.anuj.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

 private Coach mycoach;

    @Autowired
    public DemoController(Coach thecoach){
        System.out.println("Autowired started....");
            mycoach = thecoach;
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout(){
        System.out.println("dailyworkout started....");
        return mycoach.getDailyWorkout();
    }
}
