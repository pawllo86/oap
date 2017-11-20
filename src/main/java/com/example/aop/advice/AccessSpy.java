package com.example.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Aspect
@Component
public class AccessSpy {

    @Value("${readOnly}")
    private boolean readOnly;

    @Around("com.example.aop.pointcut.AccessPointcuts.inTransactionalMethod(transactional)")
    public Object readOny(ProceedingJoinPoint joinPoint, Transactional transactional) throws Throwable {
        if (!readOnly || transactional.readOnly()) {
            return joinPoint.proceed();
        } else {
            System.out.println("Your app is read only!");
            return null;
        }
    }
}
