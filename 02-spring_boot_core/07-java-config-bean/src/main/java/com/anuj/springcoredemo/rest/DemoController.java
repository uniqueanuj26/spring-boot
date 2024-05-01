package com.anuj.springcoredemo.rest;

import com.anuj.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

 private Coach mycoach;

    @Autowired
    public DemoController(@Qualifier("swimCoach") Coach thecoach){
        System.out.println("In constructor:"+ getClass().getSimpleName());
        mycoach = thecoach;

    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout(){
        return mycoach.getDailyWorkout();
    }
}
