package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging


    //@Before("execution(public void addAccount())")
    //@Before("execution(public void add*())")
    @Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    public void beforeAddAccount(JoinPoint joinPoint) {
        System.out.println("\n=========>>> Executing @Before advice on add* method)");
    }
}
