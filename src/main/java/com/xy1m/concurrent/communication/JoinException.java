package com.xy1m.concurrent.communication;

/**
 * Created by gzhenpeng on 8/3/18
 */
public class JoinException {
    public static void main(String... args) {
        try {
            ThreadB b = new ThreadB();
            b.start();
            Thread.sleep(5000);
            ThreadC c = new ThreadC(b);
            c.start();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadA extends Thread {
    public void run() {
        try {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                Thread.sleep(1000);
                System.out.println(Math.random());
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadB extends Thread {
    public void run() {
        ThreadA a = new ThreadA();
        a.start();
        try {
            a.join();
            System.out.println("ThreadB run end printing");
        }
        catch (InterruptedException e) {
            System.out.println("ThreadB catch printing");
            e.printStackTrace();
        }

    }
}

class ThreadC extends Thread {
    private ThreadB b;

    public ThreadC(ThreadB b) {
        this.b = b;
    }

    public void run() {
        b.interrupt();
    }
}
