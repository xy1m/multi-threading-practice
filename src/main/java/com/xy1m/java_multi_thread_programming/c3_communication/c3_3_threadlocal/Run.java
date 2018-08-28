package com.xy1m.java_multi_thread_programming.c3_communication.c3_3_threadlocal;

/**
 * Created by gzhenpeng on 6/28/18
 */
public class Run {
    public static ThreadLocal t1 = new ThreadLocal();
    public static ThreadLocalExt t2 = new ThreadLocalExt();


    public static void main(String... args) throws InterruptedException {
        System.out.println("Test 1=======================================");
        if (t1.get() == null) {
            System.out.println("Never put a value");
            t1.set("I am George");
        }
        System.out.println(t1.get());
        System.out.println(t1.get());
        System.out.println("Test 2=======================================");
        if (t2.get() == null) {
            System.out.println("Never put a value");
            t2.set("I am George");
        }
        System.out.println(t2.get());
        System.out.println(t2.get());
        System.out.println("Test 3=======================================");
        Runnable runnable = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread child " + Tools3.t.get());
                    Thread.sleep(100);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        for (int i = 0; i < 10; i++) {
            System.out.println("Main=" + Tools3.t.get());
            Thread.sleep(100);
        }
        Thread.sleep(1000);
        new Thread(runnable).start();
    }
}
