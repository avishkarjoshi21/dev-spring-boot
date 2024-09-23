package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPointcut() {}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePointcut() {}


    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPointcut() {}

    @Pointcut("forControllerPointcut() || forServicePointcut() || forDaoPointcut()")
    private void forAppFlow() {}


    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("=====>> in @Before: calling method" + methodName);

        for(Object arg : joinPoint.getArgs()) {
            logger.info("======>> arguments: " + arg.toString());
        }
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();

        logger.info("=====>> in @AfterReturning: from method" + methodName);

        logger.info("======>> result: " + result);

    }
}
