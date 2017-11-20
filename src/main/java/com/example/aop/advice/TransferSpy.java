package com.example.aop.advice;

import com.example.aop.model.Transfer;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransferSpy {

//    @AfterReturning(pointcut = "com.example.aop.pointcut.TransferPointcuts.transferCreated()", returning = "transfer")
    public void transferCreated(Transfer transfer) {
        System.out.println("Transfer created : " + transfer.toString());
    }
}
