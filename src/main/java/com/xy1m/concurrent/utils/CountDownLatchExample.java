package com.xy1m.concurrent.utils;

import com.xy1m.concurrent.SlowTask;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by gzhenpeng on 10/4/18
 */
public class CountDownLatchExample {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        Thread parser1 = new Thread(new SlowTask("parser1"));
        Thread parser2 = new Thread(new SlowTask("parser2"));
        parser1.start();
        parser2.start();
        try {
            parser1.join();
            parser2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All parser finished!");


        CountDownLatch cdl = new CountDownLatch(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                cdl.countDown();
                System.out.println(2);
                cdl.countDown();
            }
        }).start();
        try {
            cdl.await();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(3);


        CyclicBarrier c = new CyclicBarrier(2);
        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println(2);
                    c.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println(1);
        c.await();
        System.out.println(3);
    }



}
