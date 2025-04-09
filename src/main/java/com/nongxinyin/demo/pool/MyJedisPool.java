package com.nongxinyin.demo.pool;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class MyJedisPool extends JedisPool {

    public MyJedisPool(JedisPoolConfig jedisPoolConfig, String host, int port) {
        super(jedisPoolConfig,host,port);
    }
}
