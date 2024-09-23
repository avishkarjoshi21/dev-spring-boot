package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    List<String> countries;

    @Value("${languages}")
    List<String> languages;

    @Value("${systems}")
    List<String> systems;

    @GetMapping("/showStudentForm")
   public String showForm(Model model) {

        // create a student object
        Student student = new Student();

        // add student object to model
        model.addAttribute("student", student);

        // add the list of countries to the model
        model.addAttribute("countries", countries);

        // add the list of languages to the model
        model.addAttribute("languages", languages);

        // add the list of systems to the model
        model.addAttribute("systems", systems);

       return "student-form";
   }

   @PostMapping("/proceesStudentForm")
    public String proceesStudentForm(@ModelAttribute("student") Student student) {

        // log the input data
       System.out.println("student ::" + student.getFirstName() + " " + student.getLastName());
        return "student-confirmation";
   }
}
