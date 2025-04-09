package com.nongxinyin.demo.model;

import lombok.Data;

import java.time.LocalDate;

// DailySummary.java
@Data
public class DailySummary {
    private String userId;
    private LocalDate date;
    private double totalAmount;

    public DailySummary(String userId, LocalDate date, double totalAmount) {
        this.userId = userId;
        this.date = date;
        this.totalAmount = totalAmount;
    }
}
