package com.anuj.springcoredemo.config;

import com.anuj.springcoredemo.common.Coach;
import com.anuj.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    public Coach swimCoach(){
        System.out.println("In configuration:" + getClass().getSimpleName());
        return  new SwimCoach();
    }
}
