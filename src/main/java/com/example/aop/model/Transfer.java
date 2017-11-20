package com.example.aop.model;

import java.math.BigDecimal;

public class Transfer {

    private Long from;

    private Long to;

    private Double value;

    public static Transfer of(Long from, Long to, Double vale) {
        Transfer transfer = new Transfer();
        transfer.setFrom(from);
        transfer.setTo(to);
        transfer.setValue(vale);
        return transfer;
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "from=" + from +
                ", to=" + to +
                ", value=" + value +
                '}';
    }
}
