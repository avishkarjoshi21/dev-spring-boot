package com.luv2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    // new a controller method to show the initial HTML form

    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "process-form";
    }

    // new controller method to read data and add data to model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        // read request parameter from the HTML form
        String studentName = request.getParameter("studentName");

        // convert data to all caps
        studentName = studentName.toUpperCase();

        // create the message
        String result = "Yo! "+ studentName;

        // add message to model
        model.addAttribute("message", result);

        return "process-form";
    }

    @PostMapping("/processFormVersionThree")
    public String processFormVersinoThree(@RequestParam("studentName") String studentName, Model model) {

        // convert data to all caps
        studentName = studentName.toUpperCase();

        // create the message
        String result = "Hey My Friend from v3! "+ studentName;

        // add message to model
        model.addAttribute("message", result);

        return "process-form";
    }
}
