package com.xy1m.java_multi_thread_programming.c4_lock.c4_1_reentrant_lock.c4_1_1_reentrant_locl_test1;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by gzhenpeng on 6/24/18
 */
public class ReentrantLockTest1 {

    static class MyService {
        private Lock lock = new ReentrantLock();

        public void testMethod() {
            lock.lock();
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadName=" + Thread.currentThread().getName() + " " + (i + 1));
            }
            System.out.println();
            lock.unlock();
        }
    }

    static class MyThread extends Thread {
        private MyService service;

        public MyThread(MyService service) {
            this.service = service;
        }

        public void run() {
            service.testMethod();
        }
    }

    public static void main(String... args) throws InterruptedException {
        MyService service = new MyService();
        MyThread t1 = new MyThread(service);
        MyThread t2 = new MyThread(service);
        MyThread t3 = new MyThread(service);
        MyThread t4 = new MyThread(service);
        MyThread t5 = new MyThread(service);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

}


