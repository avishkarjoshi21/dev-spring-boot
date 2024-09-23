package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String courseCodePrefix;

    @Override
    public void initialize(CourseCode courseCode) {
       courseCodePrefix = courseCode.value();
    }

    @Override
    public boolean isValid(String courseCode, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;
        if(courseCode != null) {
            result = courseCode.startsWith(courseCodePrefix);
        }
        else {
            result = true;
        }
        return result;
    }
}
