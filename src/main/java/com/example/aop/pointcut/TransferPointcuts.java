package com.example.aop.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TransferPointcuts {

    @Pointcut("execution(* com.example.aop.helper.TransferHelper.createTransfer())")
    public void transferCreated() {}
}
