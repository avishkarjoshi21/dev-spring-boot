package com.luv2code.springboot.demo.mycoolapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // inject properties for coach.name and team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose new endpoint for "teaminfo"
    @GetMapping("/teaminfo")
    public String teamInfo() {
        return "Coach: "+coachName + ", Team Name: " + teamName;
    }

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!!";
    }

    @GetMapping("/workout")
    public String workout() {
        return "Run Hard daily 5km!!";
    }
}
