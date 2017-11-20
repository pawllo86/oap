package com.example.aop.helper;

import com.example.aop.model.Transfer;
import org.springframework.stereotype.Component;

@Component
public class TransferHelper {

    public Transfer createTransfer() {
        Long from = (long)(Math.random() * 10 + 1);
        Long to = (long)(Math.random() * 10 + 1);
        Long vale = (long)(Math.random() * 1000 + 1);

        return Transfer.of(from, to, vale.doubleValue());
    }
}
