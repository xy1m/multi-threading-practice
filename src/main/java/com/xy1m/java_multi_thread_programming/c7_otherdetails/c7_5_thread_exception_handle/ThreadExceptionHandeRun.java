package com.xy1m.java_multi_thread_programming.c7_otherdetails.c7_5_thread_exception_handle;

/**
 * Created by gzhenpeng on 8/21/18
 */
public class ThreadExceptionHandeRun {
    static class MyThread extends Thread {
        public MyThread(String name) {
            super(name);
        }

        public void run() {
            String username = null;
            System.out.println(username.hashCode());
        }
    }

    public static void main(String... args) {
        MyThread t1 = new MyThread("t1");
        t1.start();

        MyThread t2 = new MyThread("t2");
        t2.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("ThreadName:" + t.getName());
                e.printStackTrace();
            }
        });
        t2.start();

        MyThread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Default ExceptionHandler ThreadName:" + t.getName());
                e.printStackTrace();
            }
        });
        MyThread t3 = new MyThread("t3");
        t3.start();

    }
}
