package com.xy1m.java_multi_thread_programming.c7_otherdetails.c7_6_thread_group_excpetion_handle;

/**
 * Created by gzhenpeng on 8/21/18
 */
public class ThreadGroupExceptionHandleRun {
    static class MyThread extends Thread {
        private String num;

        public MyThread(ThreadGroup group, String name, String num) {
            super(group, name);
            this.num = num;
        }

        public void run() {
            int parseNum = Integer.parseInt(this.num);
            try {
                while (true) {
                    System.out.println("infinite loop:" + Thread.currentThread().getName());
                    Thread.sleep(5000);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyThreadGroup extends ThreadGroup {

        public MyThreadGroup(String name) {
            super(name);
        }

        public void uncaughtException(Thread t, Throwable throwable) {
            super.uncaughtException(t, throwable);
            this.interrupt();
        }
    }

    public static void main(String... args) {
       /* ThreadGroup group = new ThreadGroup("Group");
        for (int i = 0; i < 10; i++) {
            MyThread t = new MyThread(group, "MyThread" + i, "" + i);
            t.start();
        }
        MyThread wrong = new MyThread(group, "MyThreadWrong", "a");
        wrong.start();*/

        MyThreadGroup myThreadGroup = new MyThreadGroup("MyGroup");
        for (int i = 0; i < 10; i++) {
            MyThread t = new MyThread(myThreadGroup, "MyThread" + i, "" + i);
            t.start();
        }
        MyThread wrong = new MyThread(myThreadGroup, "MyThreadWrong", "a");
        wrong.start();

    }
}
