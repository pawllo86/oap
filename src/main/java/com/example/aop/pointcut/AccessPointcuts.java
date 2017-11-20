package com.example.aop.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.transaction.annotation.Transactional;

@Aspect
public class AccessPointcuts {

    @Pointcut("com.example.aop.pointcut.ApplicationStructure.inServiceLayer() && @target(transactional)")
    public void inTransactionalClass(Transactional transactional) {}

    @Pointcut("com.example.aop.pointcut.ApplicationStructure.inServiceLayer() && @annotation(transactional)")
    public void inTransactionalMethod(Transactional transactional) {}

}
