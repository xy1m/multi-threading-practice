package com.xy1m.concurrent.communication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gzhenpeng on 6/24/18
 */
public class TwoThreadsTransData {
    static class MyList {
        private List list = new ArrayList();

        public void add() {
            list.add("George Zhang");
        }

        public int size() {
            return list.size();
        }
    }

    static class ThreadA extends Thread {
        private MyList list;

        public ThreadA(MyList list) {
            super();
            this.list = list;
        }

        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    list.add();
                    System.out.println("Added " + (i + 1) + " element");
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class ThreadB extends Thread {
        private MyList list;

        public ThreadB(MyList list) {
            super();
            this.list = list;
        }

        public void run() {
            try {
                while (true) {
                    if (list.size() == 5) {
                        System.out.println("==5, ThreadB is going to exit");
                        throw new InterruptedException();
                    }
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String... args) {
        MyList service = new MyList();
        Thread a = new ThreadA(service);
        a.setName("A");
        a.start();
        Thread b = new ThreadB(service);
        b.setName("B");
        b.start();
    }
}
