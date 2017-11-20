package com.example.aop.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ApplicationStructure {

    @Pointcut("execution(* com.example.aop.controller.*.*(..))")
    public void inControllerLayer() {}

    @Pointcut("execution(* com.example.aop.service.*.*(..))")
    public void inServiceLayer() {}

    @Pointcut("within(com.example.aop.repository.*)")
    public void inRepositoryLayer() {}
}
