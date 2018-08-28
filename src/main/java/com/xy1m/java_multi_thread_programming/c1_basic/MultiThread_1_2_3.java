package com.xy1m.java_multi_thread_programming.c1_basic;

public class MultiThread_1_2_3 {

    static class NoVariableShareThread extends Thread {
        private int count = 5;

        public NoVariableShareThread(String name) {
            super();
            setName(name);
        }

        public synchronized void run() {
            super.run();
            while (count > 0) {
                count--;
                System.out.println(Thread.currentThread().getName() + ":" + count);
            }
        }
    }

    static class VariableShareThread extends Thread {
        private int count = 100;

        @Override
        public void run() {
            super.run();
            count--;
            System.out.println(Thread.currentThread().getName() + ":" + count);
        }
    }

    public static void main(String[] args) {
/*        Thread a = new NoVariableShareThread("A");
        Thread b = new NoVariableShareThread("B");
        Thread c = new NoVariableShareThread("C");
        a.start();
        b.start();
        c.start();*/

        Thread target = new VariableShareThread();
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(target, "Thread_" + i);
            t.start();
        }
    }
}

