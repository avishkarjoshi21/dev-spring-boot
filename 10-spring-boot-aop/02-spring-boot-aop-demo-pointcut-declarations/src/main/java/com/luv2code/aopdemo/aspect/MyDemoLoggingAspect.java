package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    //@Before("execution(public void addAccount())")
    //@Before("execution(public void add*())")
    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccount(JoinPoint joinPoint) {
        System.out.println("\n=========>>> Executing @Before advice on add* method)");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method:" + methodSignature);

        for (Object arg : joinPoint.getArgs()) {
            System.out.println("arg:" + arg);

            if(arg instanceof Account) {
                Account account = (Account) arg;
                System.out.println("account name:" + account.getName());
                System.out.println("account level:" + account.getLevel());
            }
        }
    }

    @AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>>> Executing @AfterReturning advice on find accounts: " + methodName);


        System.out.println("\n=====>>>>result is:" + result);
        convertAccountNamesToUpperCase(result);

        System.out.println("\n=====>>>>result is:" + result);
    }

    @AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "exception")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {

        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>>> Executing @AfterThrowing advice on find accounts: " + methodName);

        System.out.println("\n=====>>>>The Exception is:" + exception);
    }

    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void aferFinallyFindAccountsAdvice(JoinPoint joinPoint) {

        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>>> Executing @After (finally) advice on find accounts: " + methodName);
    }

    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>>> Executing @Around advice on get fortune: " + methodName);

        long startTime = System.currentTimeMillis();

        Object result;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println(e.getMessage());

            throw e;
            //result = "Major accident! But no worries, your private AOP helicopter is on the way!";
        }

        long endTime = System.currentTimeMillis();

        long duration = endTime - startTime;

        System.out.println("\n=====> Duration: " + duration /1000+ " seconds");
        return result;
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account account : result) {
            account.setName(account.getName().toUpperCase());
        }
    }
}
