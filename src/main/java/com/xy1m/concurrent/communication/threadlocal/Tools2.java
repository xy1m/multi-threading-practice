package com.xy1m.concurrent.communication.threadlocal;

/**
 * Created by gzhenpeng on 6/28/18
 */
public class Tools2 {
    public static ThreadLocal t = new ThreadLocal();

    public static class ThreadA extends Thread {
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    if (Tools2.t.get() == null) {
                        Tools2.t.set(System.currentTimeMillis());
                    }
                    System.out.println("ThreadA get value=" + Tools2.t.get());
                    Thread.sleep(200);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class ThreadB extends Thread {
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    if (Tools2.t.get() == null) {
                        Tools2.t.set(System.currentTimeMillis());
                    }
                    System.out.println("ThreadB get value=" + Tools2.t.get());
                    Thread.sleep(200);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String... args) throws InterruptedException {
        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();
        a.start();
        Thread.sleep(1000);
        b.start();

        for (int i = 0; i < 100; i++) {
            if (Tools2.t.get() == null) {
                Tools2.t.set(System.currentTimeMillis());
            }
            System.out.println("Main get value=" + Tools2.t.get());
            Thread.sleep(200);
        }
    }
}
