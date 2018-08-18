package com.xy1m.concurrent.communication;

/**
 * Created by gzhenpeng on 7/31/18
 */
public class JoinExample {
    public static void main(String... args) {
        try {
            MyThread t1 = new MyThread();
            t1.start();
            t1.join();
            System.out.println("I want to be executed after t1");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread {
    public void run() {
        try {
            int sec = (int) (Math.random() * 10000);
            System.out.println(sec);
            Thread.sleep(sec);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
