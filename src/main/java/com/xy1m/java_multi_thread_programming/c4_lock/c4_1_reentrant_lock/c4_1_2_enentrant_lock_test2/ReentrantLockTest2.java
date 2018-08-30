package com.xy1m.java_multi_thread_programming.c4_lock.c4_1_reentrant_lock.c4_1_2_enentrant_lock_test2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by gzhenpeng on 8/29/18
 */
public class ReentrantLockTest2 {
    static class MyService {
        private Lock lock = new ReentrantLock();

        public void testMethodA() {
            lock.lock();
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadName=" + Thread.currentThread().getName() + " Method A " + (i + 1));
            }
            System.out.println();
            lock.unlock();
        }

        public void testMethodB() {
            lock.lock();
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadName=" + Thread.currentThread().getName() + " Method B " + (i + 1));
            }
            System.out.println();
            lock.unlock();
        }
    }

    static class MyThreadA extends Thread {
        private MyService service;

        public MyThreadA(MyService service) {
            this.service = service;
        }

        public void run() {
            service.testMethodA();
        }
    }

    static class MyThreadAA extends Thread {
        private MyService service;

        public MyThreadAA(MyService service) {
            this.service = service;
        }

        public void run() {
            service.testMethodA();
        }
    }

    static class MyThreadB extends Thread {
        private MyService service;

        public MyThreadB(MyService service) {
            this.service = service;
        }

        public void run() {
            service.testMethodB();
        }
    }

    static class MyThreadBB extends Thread {
        private MyService service;

        public MyThreadBB(MyService service) {
            this.service = service;
        }

        public void run() {
            service.testMethodB();
        }
    }

    public static void main(String... args) {
        MyService service = new MyService();
        MyThreadA t1 = new MyThreadA(service);
        t1.setName("A");
        MyThreadAA t2 = new MyThreadAA(service);
        t2.setName("AA");
        MyThreadB t3 = new MyThreadB(service);
        t3.setName("B");
        MyThreadBB t4 = new MyThreadBB(service);
        t4.setName("BB");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
