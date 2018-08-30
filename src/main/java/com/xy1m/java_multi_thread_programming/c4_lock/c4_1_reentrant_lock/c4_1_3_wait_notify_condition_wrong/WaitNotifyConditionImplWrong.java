package com.xy1m.java_multi_thread_programming.c4_lock.c4_1_reentrant_lock.c4_1_3_wait_notify_condition_wrong;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by gzhenpeng on 8/29/18
 */
public class WaitNotifyConditionImplWrong {
    static class MyService {
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void await() {
            try {
                condition.await();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
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

    public static void main(String... args) {
        MyThread t1 = new MyThread(new MyService());
        t1.start();
    }
}
