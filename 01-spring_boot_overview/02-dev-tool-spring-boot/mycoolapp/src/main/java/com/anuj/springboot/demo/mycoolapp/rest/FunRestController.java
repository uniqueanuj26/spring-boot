package com.anuj.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${team.name}")
    private String teamname;

    @Value("${coach.name}")
    private String coachname;

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Team Name:" + teamname +", Coach Name:"+ coachname;
    }
    @GetMapping("/")
    public String sayHello(){
        return "Hello,World!!!";
    }

    @GetMapping("/about_us")
    public String about(){
        return "About Us";
    }

    @GetMapping("/contact")
    public String contact(){
        return "Contact Details";
    }
}
