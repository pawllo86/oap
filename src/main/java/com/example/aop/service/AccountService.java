package com.example.aop.service;

import com.example.aop.model.Account;
import com.example.aop.model.Transfer;
import com.example.aop.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collection;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    @Transactional(readOnly = true)
    public Collection<Account> getAllAccounts() {
        return repository.getAllAccounts();
    }

    @Transactional(readOnly = true)
    public Account getAccount(Long number) {
        return repository.getAccount(number);
    }

    @Transactional
    public void transfer(Transfer transfer) throws Exception {
        if (transfer.getFrom().equals(transfer.getTo())) {
            throw new Exception("Transfer for the same account!");
        }
        Account accountFrom = repository.getAccount(transfer.getFrom());
        Account accountTo = repository.getAccount(transfer.getTo());

        BigDecimal resultFrom = BigDecimal.valueOf(accountFrom.getValue()).subtract(BigDecimal.valueOf(transfer.getValue()));
        BigDecimal resultTo = BigDecimal.valueOf(accountTo.getValue()).add(BigDecimal.valueOf(transfer.getValue()));

        if (resultFrom.doubleValue() < 0) {
            throw new Exception("Not enough money!");
        }
        accountFrom.setValue(resultFrom.doubleValue());
        repository.save(accountFrom);
        accountTo.setValue(resultTo.doubleValue());
        repository.save(accountTo);
    }
}
