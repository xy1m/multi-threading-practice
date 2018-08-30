package com.xy1m.java_multi_thread_programming.c4_lock.c4_1_reentrant_lock.c4_1_9_fair_unfair_lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by gzhenpeng on 8/29/18
 */
public class FairLockRun {

    static class Service {
        private ReentrantLock lock;

        public Service(boolean isFair) {
            super();
            lock = new ReentrantLock(isFair);
        }

        public void testMethod() {
            try {
                lock.lock();
                System.out.println("ThreadName=" + Thread.currentThread().getName() + " acquired lock");
            }
            finally {
                lock.unlock();
            }
        }
    }

    public static void main(String... args) {
        final Service service = new Service(true);
        //final Service service = new Service(false);
        Runnable runnable = () -> {
            System.out.println("Thread=" + Thread.currentThread().getName() + " is running");
            service.testMethod();
        };

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(runnable);
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }
}
