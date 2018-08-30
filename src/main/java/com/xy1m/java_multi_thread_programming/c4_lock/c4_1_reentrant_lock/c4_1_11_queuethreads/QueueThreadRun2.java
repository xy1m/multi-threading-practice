package com.xy1m.java_multi_thread_programming.c4_lock.c4_1_reentrant_lock.c4_1_11_queuethreads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by gzhenpeng on 8/29/18
 */
public class QueueThreadRun2 {

    static class Service {
        private ReentrantLock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void waitMethod() {
            try {
                lock.lock();
                condition.await();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }

        public void notifyMethod() {
            try {
                lock.lock();
                System.out.println("waiting for condition?" + lock.hasWaiters(condition) + " count: " + lock.getWaitQueueLength(condition));
                condition.signal();
            }
            finally {
                lock.unlock();
            }
        }
    }

    public static void main(String... args) throws InterruptedException {
        final Service service = new Service();
        Runnable runnable = () -> {
            service.waitMethod();
        };
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(runnable);
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
        Thread.sleep(2000);
        service.notifyMethod();

    }
}
