package com.example.aop.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AccountPointcuts {

    @Pointcut("execution(* com.example.aop.service.AccountService.transfer(..))")
    public void transfer() {}
}
