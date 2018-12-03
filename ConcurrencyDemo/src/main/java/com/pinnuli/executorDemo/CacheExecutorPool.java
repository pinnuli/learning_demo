package com.pinnuli.executorDemo;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.*;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-11-15
 */

public class CacheExecutorPool {
    private static Random rnd = new Random();
    private final int sleep_time = rnd.nextInt(10) + 1;
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(sleep_time);
        } catch(InterruptedException e) {
            System.err.println("Interrupted: " + e);
        }
        System.out.println(sleep_time);
    }
}
