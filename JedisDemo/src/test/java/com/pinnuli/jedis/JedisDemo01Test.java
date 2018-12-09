package com.pinnuli.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisDemo01Test {

    /**
     * 单实例测试
     */
    @Test
    public void demo1() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.auth("123456");
        jedis.set("name", "pinnuli");
        System.out.println(jedis.get("name"));
        jedis.close();
    }

    /**
     * 连接池测试
     */
    @Test
    public void demo2() {
        // 连接池的配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxTotal(30);
        // 设置最大空闲连接数
        config.setMaxIdle(10);

        //获得连接池
        JedisPool jedisPool = new JedisPool("127.0.0.1", 6379);

        //获得核心对象
        Jedis jedis = null;
        try {
            // 获取连接
            jedis = jedisPool.getResource();
            // 设置密码
            jedis.auth("123456");
            // 设置值
            jedis.set("name2", "pinnuli");
            // 获取值
            String value = jedis.get("name");
            System.out.println(value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
            if (jedisPool != null) {
                jedisPool.close();
            }
        }
    }
}
