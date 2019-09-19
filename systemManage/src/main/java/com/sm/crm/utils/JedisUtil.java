package com.sm.crm.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisUtil {

    private static JedisPool jedisPool;

    static {
        InputStream in = JedisUtil.class.getClassLoader().getResourceAsStream("redis.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);
            JedisPoolConfig config = new JedisPoolConfig();
            // 最大空闲数
            config.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));
            // 最大连接数
            config.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
            jedisPool = new JedisPool(config, properties.getProperty("host"), Integer.parseInt(properties.getProperty("port")));
        } catch (IOException e) {
            throw new RuntimeException("配置文件加载失败");
        }

    }

    /**
     * 这个是获得Jedis
     *
     * @return
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    /**
     * 释放资源
     */
    public static void release(Jedis jedis) {
        //这个表示当前jedis链接 放到我们链接池中  并不是关闭了
        jedis.close();
    }

}
