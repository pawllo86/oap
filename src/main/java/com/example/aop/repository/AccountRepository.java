package com.example.aop.repository;

import com.example.aop.model.Account;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccountRepository {

    private static Map<Long, Account> accounts = new HashMap<>();

    static {
        accounts.put(1L, Account.of(1L, "Jan Kowalski", 10000d));
        accounts.put(2L, Account.of(2L, "Adam Małysz", 10000d));
        accounts.put(3L, Account.of(3L, "Piotr Żyła", 10000d));
        accounts.put(4L, Account.of(4L, "Robert Lewandowski", 10000d));
        accounts.put(5L, Account.of(5L, "Kamil Stoch", 10000d));
        accounts.put(6L, Account.of(6L, "Sławomir Peszko", 10000d));
        accounts.put(7L, Account.of(7L, "Artur Boruc", 10000d));
        accounts.put(8L, Account.of(8L, "Michał Pazdan", 10000d));
        accounts.put(9L, Account.of(9L, "Leszek Nowak", 10000d));
        accounts.put(10L, Account.of(10L, "Kamil Grosicki", 10000d));
    }

    public Collection<Account> getAllAccounts() {
        return accounts.values();
    }

    public Account getAccount(Long number) {
        return accounts.get(number);
    }

    public void save(Account account) {
        accounts.put(account.getNumber(), account);
    }

}
