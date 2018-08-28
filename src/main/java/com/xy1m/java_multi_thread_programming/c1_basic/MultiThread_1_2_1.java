package com.xy1m.java_multi_thread_programming.c1_basic;

public class MultiThread_1_2_1 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        class MyThread extends Thread {
            @Override
            public void run() {
                System.out.println("MyThread");
            }
        }
        MyThread myThread = new MyThread();
        //myThread.start();
        myThread.run();
        System.out.println("End");
        System.out.println(Thread.currentThread().getId());
    }
}
