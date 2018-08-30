package com.xy1m.java_multi_thread_programming.c4_lock.c4_2_reentrant_read_write_lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by gzhenpeng on 8/29/18
 */
public class ReentrantReadWriteLockRun {
    static class Service {
        private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        public void read() {
            try {
                try {
                    lock.readLock().lock();
                    System.out.println("Acquired lock " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                    Thread.sleep(2000);
                }
                finally {
                    lock.readLock().unlock();
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void write() {
            try {
                try {
                    lock.writeLock().lock();
                    System.out.println("Acquired lock " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                    Thread.sleep(2000);
                }
                finally {
                    lock.writeLock().unlock();
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadA extends Thread {
        private Service service;

        public ThreadA(Service service) {
            this.service = service;
        }

        public void run() {
            service.read();
        }
    }

    static class ThreadB extends Thread {
        private Service service;

        public ThreadB(Service service) {
            this.service = service;
        }

        public void run() {
            service.write();
        }
    }

    public static void main(String... args) throws InterruptedException {
        Service service = new Service();
        // test read read lock
        /*for (int i = 0; i < 10; i++) {
            new ThreadA(service).start();
        }*/

        // test write write lock
        /*for (int i = 0; i < 10; i++) {
            new ThreadB(service).start();
        }*/

        // test read and write
        /*ThreadA a = new ThreadA(service);
        a.setName("ThreadA");
        a.start();
        Thread.sleep(1000);
        ThreadB b = new ThreadB(service);
        b.setName("ThreadB");
        b.start();*/

        // test write and read
        ThreadB b = new ThreadB(service);
        b.setName("ThreadB");
        b.start();
        Thread.sleep(1000);
        ThreadA a = new ThreadA(service);
        a.setName("ThreadA");
        a.start();
    }
}
