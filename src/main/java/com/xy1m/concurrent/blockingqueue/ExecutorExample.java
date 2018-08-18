package com.xy1m.concurrent.blockingqueue;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by gzhenpeng on 8/15/18
 */
public class ExecutorExample {
    public static void main(String... args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            Random random = new Random();
            int ran = random.nextInt(10);
            if (ran % 2 == 0) {
                System.out.println("fail");
                throw new RuntimeException("fail");
            }
            System.out.println(ran);
        });
    }
}
