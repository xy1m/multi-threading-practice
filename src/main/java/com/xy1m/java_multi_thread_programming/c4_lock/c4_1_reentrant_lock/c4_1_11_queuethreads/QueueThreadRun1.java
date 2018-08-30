package com.xy1m.java_multi_thread_programming.c4_lock.c4_1_reentrant_lock.c4_1_11_queuethreads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by gzhenpeng on 8/29/18
 */
public class QueueThreadRun1 {

    static class Service {
        private ReentrantLock lock = new ReentrantLock();

        public void waitMethod() {
            try {
                lock.lock();
                Thread.sleep(10000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
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
        Thread a = new Thread(runnable);
        Thread b = new Thread(runnable);
        a.start();
        b.start();
        Thread.sleep(500);
        System.out.println(service.lock.hasQueuedThread(a));
        System.out.println(service.lock.hasQueuedThread(b));
        System.out.println(service.lock.hasQueuedThreads());
    }
}
