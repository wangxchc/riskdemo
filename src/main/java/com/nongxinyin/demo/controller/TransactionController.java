package com.nongxinyin.demo.controller;

import com.nongxinyin.demo.model.Transaction;
import com.nongxinyin.demo.service.RiskControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

// TransactionController.java
@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private RiskControlService riskControlService;

    @PostMapping
    public Transaction processTransaction(@RequestBody Transaction transaction) {
        transaction.setTimestamp(LocalDateTime.now());
        return riskControlService.checkTransaction(transaction);
    }
}
