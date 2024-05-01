package com.anuj.springcoredemo.rest;

import com.anuj.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

 private Coach mycoach;

    @Autowired
    public void setCoach(Coach thecoach){
            mycoach = thecoach;
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout(){
        return mycoach.getDailyWorkout();
    }
}
