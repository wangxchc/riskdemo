package com.nongxinyin;

import com.nongxinyin.demo.config.RedisConfig;
import com.nongxinyin.demo.model.Transaction;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.LocalDateTime;

public class RiskDemoMain {

    private static String host = "43.134.79.177";
    private static int port = 6379;

    public static void main(final String[] args) {
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        execute(kc);
    }

    public static void execute(KieContainer kc) {
        RedisConfig rc = new RedisConfig(host,port);
        JedisPool redisPool =rc.jedisPool();
        KieSession session = kc.newKieSession("riskControlSession");
        session.setGlobal("myRedisPool", redisPool);
        Transaction transaction = new Transaction();
        transaction.setUserId("user1");
        transaction.setAmount(100.00);
        transaction.setTimestamp(LocalDateTime.now());
        long start = System.currentTimeMillis();
        session.insert(transaction);
        session.fireAllRules();

        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
        session.dispose(); // Stateful rule session must always be disposed when finished
    }
}
