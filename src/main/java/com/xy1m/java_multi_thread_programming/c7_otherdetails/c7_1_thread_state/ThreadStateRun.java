package com.xy1m.java_multi_thread_programming.c7_otherdetails.c7_1_thread_state;

/**
 * Created by gzhenpeng on 8/21/18
 */
public class ThreadStateRun {
    static class MyThread extends Thread {
        public MyThread() {
            System.out.println("Constructor(Main):" + Thread.currentThread().getState());
        }

        public void run() {
            System.out.println("Run state:" + Thread.currentThread().getState());
        }
    }

    static class MyThread1 extends Thread {
        public MyThread1() {
        }

        public void run() {
            try {
                System.out.println("sleep begin");
                Thread.sleep(2000);
                System.out.println("sleep end");
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyThread2 extends Thread {
        public MyThread2() {
        }

        public void run() {
            MyService.serviceMethod();
        }
    }

    static class MyService {
        public static synchronized void serviceMethod() {
            System.out.println(Thread.currentThread().getName() + " enter service method");
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String... args) throws InterruptedException {
        MyThread t0 = new MyThread();
        System.out.println("t0 start " + t0.getState());
        t0.start();
        Thread.sleep(1000);
        System.out.println("t0 end " + t0.getState());
        System.out.println();

        MyThread1 t1 = new MyThread1();
        t1.start();
        Thread.sleep(1000);
        System.out.println("t1 " + t1.getState());
        Thread.sleep(3000);
        System.out.println();

        MyThread2 t21 = new MyThread2();
        MyThread2 t22 = new MyThread2();
        t21.start();
        t22.start();
        Thread.sleep(1000);
        System.out.println("t21 " + t21.getState());
        System.out.println("t22 " + t22.getState());
    }
}
