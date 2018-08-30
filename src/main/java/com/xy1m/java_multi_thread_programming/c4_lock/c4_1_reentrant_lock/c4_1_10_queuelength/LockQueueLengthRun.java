package com.xy1m.java_multi_thread_programming.c4_lock.c4_1_reentrant_lock.c4_1_10_queuelength;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by gzhenpeng on 8/29/18
 */
public class LockQueueLengthRun {
    static class Service {
        private ReentrantLock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void serviceMethod1() {
            try {
                lock.lock();
                System.out.println("serviceMethod1 getHoldCount=" + lock.getHoldCount());
                serviceMethod2();
            }
            finally {
                lock.unlock();
            }
        }

        public void serviceMethod2() {
            try {
                lock.lock();
                System.out.println("serviceMethod2 getHoldCount=" + lock.getHoldCount());
            }
            finally {
                lock.unlock();
            }
        }

        public void serviceMethod3() {
            try {
                lock.lock();
                System.out.println("ThreadName=" + Thread.currentThread().getName() + " run");
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }

        public void serviceMethod4() {
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
                System.out.println(lock.getWaitQueueLength(condition) + " are waiting condition");
            }
            finally {
                lock.unlock();
            }
        }

        public static void main(String... args) throws InterruptedException {
            Service service = new Service();
            service.serviceMethod1();

            /*Runnable runnable3 = () -> {
                service.serviceMethod3();
            };

            Thread[] threads3 = new Thread[10];
            for (int i = 0; i < 10; i++) {
                threads3[i] = new Thread(runnable3);
            }
            for (int i = 0; i < 10; i++) {
                threads3[i].start();
            }
            Thread.sleep(2000);
            System.out.println("Waiting threads:" + service.lock.getQueueLength());*/

            Runnable runnable4 = () -> {
                service.serviceMethod4();
            };
            Thread[] threads4 = new Thread[10];
            for (int i = 0; i < 10; i++) {
                threads4[i] = new Thread(runnable4);
            }
            for (int i = 0; i < 10; i++) {
                threads4[i].start();
            }
            Thread.sleep(2000);
            service.notifyMethod();
        }
    }
}
