package com.example.AOPDemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Helper {
    // Cross-cutting concerns
//    public  static  void log(){
//        System.out.println("print-only when method is executed!");
//    }

//    @Pointcut("execution(public void show())")
//    public void pointcut() {
//    }

    @Before("execution(public * show(int,..))")   //"pointcut()"
    public void log() {
        System.out.println("before function execution");
    }
//
//    @After("pointcut()")//"execution(public void show())"
//    public void afterLog() {
//        System.out.println("after function execution");
//    }

//    @Around("pointcut()")
//    public void aroundLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//        System.out.println("before");
//        proceedingJoinPoint.proceed();
//        System.out.println("after");
//    }



}