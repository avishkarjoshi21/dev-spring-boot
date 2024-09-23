package com.luv2code.springboot.demo.mycoolapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!!";
    }

    @GetMapping("/workout")
    public String workout() {
        return "Run Hard daily 5km!!";
    }
}
