package com.anuj.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{

    public BaseBallCoach() {
        System.out.println("In constructor:"+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Baseball coaching....";
    }
}
