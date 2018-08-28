package com.xy1m.java_multi_thread_programming.c1_basic;

public class MultiThread_1_2_2 {
    public static void main(String[] args) {
        class MyRunnable implements Runnable {
            @Override
            public void run() {
                System.out.println("MyRunnable");
            }
        }
        Runnable runnable = new MyRunnable();
        new Thread(runnable).start();
        System.out.println("End");
    }
}
