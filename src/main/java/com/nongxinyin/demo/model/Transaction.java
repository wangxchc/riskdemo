package com.nongxinyin.demo.model;

import lombok.Data;

import java.time.LocalDateTime;

// Transaction.java
@Data
public class Transaction {
    private String userId;
    private double amount;
    private LocalDateTime timestamp;
    private boolean rejected;
}
