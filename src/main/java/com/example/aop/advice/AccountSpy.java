package com.example.aop.advice;

import com.example.aop.model.Account;
import com.example.aop.model.Transfer;
import com.example.aop.service.AccountService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AccountSpy {

    @Autowired
    private AccountService service;

    @Before("com.example.aop.pointcut.AccountPointcuts.transfer() && args(transfer)")
    public void startTransfer(Transfer transfer) {
        if (transfer.getValue() > 900) {
            System.out.println("Big transfer: " + transfer.toString());
        }
    }

    @AfterReturning("com.example.aop.pointcut.AccountPointcuts.transfer() && args(transfer)")
    public void finishTransfer(Transfer transfer) {
        Account from = service.getAccount(transfer.getFrom());
        Account to = service.getAccount(transfer.getTo());

        if (from.getValue() < 1000) {
            System.out.println("Maybe loan is required: " + from.getUser() + " account value: " + from.getValue());
        }
        if (to.getValue() > 20000) {
            System.out.println("Maybe investment is required: " + from.getUser() + " account value: " + to.getValue());
        }
    }

//    @AfterReturning("com.example.aop.pointcut.AccountPointcuts.transfer()")
//    public void stopTransfer() {
//        System.out.println("Transfer done");
//    }

    @AfterThrowing(value = "com.example.aop.pointcut.AccountPointcuts.transfer()", throwing = "e")
    public void failTransfer(Exception e) {
        System.out.println("Transfer failed due to: " + e.getMessage());
    }

//    @Around("com.example.aop.pointcut.ApplicationStructure.inRepositoryLayer()")
    public Object performance(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long stop = System.currentTimeMillis();

        System.out.println("Database access within " + joinPoint.getSignature().getName() + "() took " + (stop - start) + " milis");
        return result;
    }
}
