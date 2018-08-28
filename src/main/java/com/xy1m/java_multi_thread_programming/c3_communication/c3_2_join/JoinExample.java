package com.xy1m.java_multi_thread_programming.c3_communication.c3_2_join;

/**
 * Created by gzhenpeng on 7/31/18
 */
public class JoinExample {
    private static class MyThread extends Thread {
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


