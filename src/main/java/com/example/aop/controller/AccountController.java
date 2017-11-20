package com.example.aop.controller;

import com.example.aop.helper.TransferHelper;
import com.example.aop.model.Account;
import com.example.aop.model.Transfer;
import com.example.aop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class AccountController {

    @Autowired
    private AccountService service;

    @Autowired
    private TransferHelper helper;

    public void displayAccounts() {
        System.out.println("=====================================================");
        Collection<Account> accounts = service.getAllAccounts();

        accounts.forEach(account -> System.out.println(account.getNumber() + " : " + account.getUser()
            + " - " + account.getValue()));
        System.out.println("=====================================================");
    }

    public void sumAccounts() {
        System.out.println("=====================================================");
        Collection<Account> accounts = service.getAllAccounts();
        double sum = accounts.stream().mapToDouble(account -> account.getValue()).sum();
        System.out.println("================= SUMA: " + sum + "=====================");
        System.out.println("=====================================================");
    }

    public void doRandomTransfer(int amount) {
        while(amount > 0) {
            try {
                service.transfer(helper.createTransfer());
            } catch (Exception e) {

            }
            amount--;
        }
    }

}
