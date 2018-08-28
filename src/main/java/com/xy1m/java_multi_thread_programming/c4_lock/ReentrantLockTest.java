package com.xy1m.java_multi_thread_programming.c4_lock;


import java.time.LocalDateTime;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by gzhenpeng on 6/24/18
 */
public class ReentrantLockTest {
    public static void main(String... args) throws InterruptedException {
        MyService service = new MyService();
        MyThread t1 = new MyThread(service);
        t1.start();
        Thread.sleep(3000);
        service.signal();
    }

    static class MyService {
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void testMethod() {
            lock.lock();
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadName=" + Thread.currentThread().getName() + " " + (i + 1));
            }
            lock.unlock();
        }

        public void waitMethod() {
            try {
                lock.lock();
                System.out.println("A");
                condition.await();
                System.out.println("B");
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
                System.out.println("Lock released");
            }
        }

        public void await() {
            try {
                lock.lock();
                System.out.println("Await timestamp:" + LocalDateTime.now());
                System.out.println("Await current thread:" + Thread.currentThread().getName());
                condition.await();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                System.out.println("Await finally:" + LocalDateTime.now());

                lock.unlock();
            }
        }

        public void signal() {
            try {
                lock.lock();
                System.out.println("Signal timestamp:" + LocalDateTime.now());
                System.out.println("Await current thread:" + Thread.currentThread().getName());
                condition.signal();
            }
            finally {
                System.out.println("Signal finally:" + LocalDateTime.now());
                lock.unlock();
            }
        }
    }

    static class MyThread extends Thread {
        private MyService service;

        public MyThread(MyService service) {
            this.service = service;
        }

        public void run() {
            service.await();
        }
    }
}


