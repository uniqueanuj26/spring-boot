package com.anuj.util;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        System.out.println("interface implemented....");
        return "Cricket Coaching.....";
    }
}
