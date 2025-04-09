package com.nongxinyin.demo.service;

import com.nongxinyin.demo.model.Transaction;
import com.nongxinyin.demo.pool.MyJedisPool;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

// RiskControlService.java
@Service
public class RiskControlService {
    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private MyJedisPool jedisPool;

    public Transaction checkTransaction(Transaction transaction) {
        KieSession kieSession = kieContainer.newKieSession("riskControlSession");
        kieSession.setGlobal("myRedisPool", jedisPool);
        kieSession.insert(transaction);
        kieSession.fireAllRules();
        kieSession.dispose();
        return transaction;
    }
}
