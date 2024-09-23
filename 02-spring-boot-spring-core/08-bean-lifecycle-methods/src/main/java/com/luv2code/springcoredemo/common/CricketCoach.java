package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("Inside Constructor :" + getClass().getSimpleName());
    }

    // define our init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("Inside doMyStartupStuff() :" + getClass().getSimpleName());
    }

    // define our destroy method

    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("Inside doMyCleanupStuff() :" + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bolwing for 15 minutes";
    }


}
