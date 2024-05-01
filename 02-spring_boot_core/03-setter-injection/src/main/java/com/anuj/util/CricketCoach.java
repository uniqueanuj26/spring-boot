package com.anuj.util;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Cricket Coaching for bowling and batting";
    }
}
