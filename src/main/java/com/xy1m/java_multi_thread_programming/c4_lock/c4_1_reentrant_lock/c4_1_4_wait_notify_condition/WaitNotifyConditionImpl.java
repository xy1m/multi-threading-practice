package com.xy1m.java_multi_thread_programming.c4_lock.c4_1_reentrant_lock.c4_1_4_wait_notify_condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by gzhenpeng on 8/29/18
 */
public class WaitNotifyConditionImpl {
    static class MyService {
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void await() {
            try {
                lock.lock();
                System.out.println("Await timestamp:" + System.currentTimeMillis());
                condition.await();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }

        public void signal() {
            try {
                lock.lock();
                System.out.println("Signal timestamp:" + System.currentTimeMillis());
                condition.signal();
            }
            finally {
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

    public static void main(String... args) throws InterruptedException {
        MyService myService = new MyService();
        MyThread t1 = new MyThread(myService);
        t1.start();
        Thread.sleep(3000);
        myService.signal();
    }
}
