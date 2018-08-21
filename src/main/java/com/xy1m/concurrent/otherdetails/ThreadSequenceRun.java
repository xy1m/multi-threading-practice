package com.xy1m.concurrent.otherdetails;

/**
 * Created by gzhenpeng on 8/21/18
 */
public class ThreadSequenceRun {
    private static class MyThread extends Thread {
        private Object lock;
        private String showChar;
        private int showNumPosition;
        private int printCount = 0;
        volatile private static int addNumber = 1;

        public MyThread(Object lock, String showChar, int showNumPosition) {
            this.lock = lock;
            this.showChar = showChar;
            this.showNumPosition = showNumPosition;
        }

        public void run() {
            try {
                synchronized (lock) {
                    while ((true)) {
                        /*Thread.sleep(1000);
                        System.out.println("======ThreadName " + Thread.currentThread().getName());
                        System.out.println("addNumber " + addNumber);
                        System.out.println("showChar " + showChar);
                        System.out.println("showNumPosition " + showNumPosition);
                        System.out.println("printCount " + printCount);*/
                        if (addNumber % 3 == showNumPosition) {
                            System.out.println("ThreadName " + Thread.currentThread().getName() + " runCount " +
                                    addNumber +
                                    " " + showChar);
                            lock.notifyAll();
                            addNumber++;
                            printCount++;
                            if (printCount == 3) {
                                break;
                            }
                        }
                        else {
                            lock.wait();
                        }
                    }
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Object lock = new Object();
        MyThread a = new MyThread(lock, "A", 1);
        MyThread b = new MyThread(lock, "B", 2);
        MyThread c = new MyThread(lock, "C", 0);
        a.start();
        b.start();
        c.start();
    }
}
