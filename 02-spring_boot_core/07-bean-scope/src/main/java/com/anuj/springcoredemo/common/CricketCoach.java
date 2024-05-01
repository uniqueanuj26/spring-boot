package com.anuj.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.logging.LoggerConfiguration;
import org.springframework.boot.logging.log4j2.SpringBootConfigurationFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach{
    public CricketCoach() {
        System.out.println("In constructor:"+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Cricket Coaching.....";
    }
}
