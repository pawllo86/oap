package com.example.aop.model;

public class Account {

    private Long number;

    private String user;

    private Double value;

    public static Account of(Long number, String user, Double vale) {
        Account account = new Account();
        account.setNumber(number);
        account.setUser(user);
        account.setValue(vale);
        return account;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", user='" + user + '\'' +
                ", value=" + value +
                '}';
    }
}
