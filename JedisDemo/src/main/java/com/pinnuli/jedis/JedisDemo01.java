package com.pinnuli.jedis;

import redis.clients.jedis.Jedis;
/**
 * @author: pinnuli
 * @date: 2018-12-04
 */

public class JedisDemo01 {

    public void demo1() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("name", "pinnuli");
        System.out.println(jedis.get("name"));
        jedis.close();
    }
}
