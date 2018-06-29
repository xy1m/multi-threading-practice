package com.xy1m.concurrent.communication.threadlocal;

/**
 * Created by gzhenpeng on 6/28/18
 */
public class Tools {
    public static ThreadLocal t = new ThreadLocal();

    static class ThreadA extends Thread {
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    Tools.t.set("ThreadA " + (i + 1));
                    System.out.println("ThreadA get value=" + Tools.t.get());
                    Thread.sleep(200);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadB extends Thread {
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    Tools.t.set("ThreadB " + (i + 1));
                    System.out.println("ThreadB get value=" + Tools.t.get());
                    Thread.sleep(200);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String... args) {
        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();
        a.start();
        b.start();

        try {
            for (int i = 0; i < 100; i++) {
                Tools.t.set("Main " + (i + 1));
                System.out.println("Main get value=" + Tools.t.get());
                Thread.sleep(200);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
