package com.anuj.springcoredemo.rest;

import com.anuj.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

 private Coach mycoach;
 private Coach myanothercoach;

    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach thecoach,
                          @Qualifier("cricketCoach") Coach theanothercoach){
        System.out.println("In constructor:"+ getClass().getSimpleName());
        mycoach = thecoach;
        myanothercoach = theanothercoach;

    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout(){
        return mycoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "Checking mycoach == myanothercoach,"+ (mycoach == myanothercoach);
    }
}
