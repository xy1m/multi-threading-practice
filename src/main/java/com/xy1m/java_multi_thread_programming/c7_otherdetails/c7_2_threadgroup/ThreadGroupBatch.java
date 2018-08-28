package com.xy1m.java_multi_thread_programming.c7_otherdetails.c7_2_threadgroup;

/**
 * Created by gzhenpeng on 8/21/18
 */
public class ThreadGroupBatch {
    private static class MyThread extends Thread {
        public MyThread(ThreadGroup group, String name) {
            super(group, name);
        }

        public void run() {
            System.out.println("ThreadName:" + Thread.currentThread().getName() + " infinite loop begin");
            while (!this.isInterrupted()) {
            }
            System.out.println("ThreadName:" + Thread.currentThread().getName() + " infinite loop end");

        }
    }

    public static void main(String... args) {
        ThreadGroup group = new ThreadGroup("MyGroup");
        for (int i = 0; i < 5; i++) {
            MyThread thread = new MyThread(group, "MyThread" + (i + 1));
            thread.start();
        }
        try {
            Thread.sleep(1000);
            group.interrupt();
            System.out.println("Main invoke interrupt method");
        }
        catch (InterruptedException e) {
            System.out.println("Stop stop");
            e.printStackTrace();
        }
    }

}
