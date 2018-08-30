package com.xy1m.java_multi_thread_programming.c4_lock.c4_1_reentrant_lock.c4_1_6_wait_notify_condition_selective;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by gzhenpeng on 8/29/18
 */
public class WaitNotifyConditionSelectiveImpl {
    static class MyService {
        private Lock lock = new ReentrantLock();
        private Condition conditionA = lock.newCondition();
        private Condition conditionB = lock.newCondition();

        public void awaitA() {
            try {
                lock.lock();
                System.out.println("Await A timestamp:" + System.currentTimeMillis());
                conditionA.await();
                System.out.println("End A timestamp:" + System.currentTimeMillis());
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }

        public void awaitB() {
            try {
                lock.lock();
                System.out.println("Await B timestamp:" + System.currentTimeMillis());
                conditionB.await();
                System.out.println("End B timestamp:" + System.currentTimeMillis());
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }

        public void signalAllA() {
            try {
                lock.lock();
                System.out.println("SignalAll A timestamp:" + System.currentTimeMillis());
                conditionA.signalAll();
            }
            finally {
                lock.unlock();
            }
        }

        public void signalAllB() {
            try {
                lock.lock();
                System.out.println("SignalAll B timestamp:" + System.currentTimeMillis());
                conditionB.signalAll();
            }
            finally {
                lock.unlock();
            }
        }
    }

    static class MyThreadA extends Thread {
        private MyService service;

        public MyThreadA(MyService service) {
            this.service = service;
        }

        public void run() {
            service.awaitA();
        }
    }

    static class MyThreadB extends Thread {
        private MyService service;

        public MyThreadB(MyService service) {
            this.service = service;
        }

        public void run() {
            service.awaitB();
        }
    }

    public static void main(String... args) throws InterruptedException {
        MyService myService = new MyService();
        MyThreadA a = new MyThreadA(myService);
        MyThreadB b = new MyThreadB(myService);
        a.start();
        b.start();
        Thread.sleep(3000);
        myService.signalAllA();
    }
}
