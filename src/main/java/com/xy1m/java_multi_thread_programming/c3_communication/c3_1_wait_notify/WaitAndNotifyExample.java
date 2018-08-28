package com.xy1m.java_multi_thread_programming.c3_communication.c3_1_wait_notify;

/**
 * Created by gzhenpeng on 6/29/18
 */
public class WaitAndNotifyExample {
    public static void main(String... args) throws InterruptedException {
        /*try {
            String lock = "Hello";
            System.out.println("syn up");
            synchronized (lock) {
                System.out.println("syn #1");
                lock.wait();
                System.out.println("wait down");
            }
            System.out.println("syn down");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        Object lock = new Object();
        ThreadWait threadWait = new ThreadWait(lock);
        ThreadNotify threadNotify = new ThreadNotify(lock);
        threadWait.start();
        Thread.sleep(3000);
        threadNotify.start();
    }

    static class ThreadWait extends Thread {
        private Object lock;

        public ThreadWait(Object object) {
            this.lock = object;
        }

        public void run() {
            try {
                synchronized (lock) {
                    System.out.println("Begin wait " + System.currentTimeMillis());
                    lock.wait();
                    System.out.println("Stop wait " + System.currentTimeMillis());
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadNotify extends Thread {
        private Object lock;

        public ThreadNotify(Object object) {
            this.lock = object;
        }

        public void run() {
            synchronized (lock) {
                System.out.println("Begin notify " + System.currentTimeMillis());
                lock.notify();
                try {
                    Thread.sleep(5000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Stop notify " + System.currentTimeMillis());
            }
        }
    }
}
