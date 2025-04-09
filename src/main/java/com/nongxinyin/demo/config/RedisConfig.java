package com.nongxinyin.demo.config;

import com.nongxinyin.demo.pool.MyJedisPool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPoolConfig;

// RedisConfig.java
@Configuration
public class RedisConfig {
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    public RedisConfig() {

    }

    public RedisConfig(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Bean
    public MyJedisPool jedisPool() {
        return new MyJedisPool(new JedisPoolConfig(), host, port);
    }
}
