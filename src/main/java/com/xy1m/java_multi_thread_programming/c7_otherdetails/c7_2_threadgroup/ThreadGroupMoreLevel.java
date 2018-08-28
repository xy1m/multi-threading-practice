package com.xy1m.java_multi_thread_programming.c7_otherdetails.c7_2_threadgroup;

/**
 * Created by gzhenpeng on 8/19/18
 */
public class ThreadGroupMoreLevel {
    public static void main(String... args) {
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup group = new ThreadGroup(mainGroup, "A");

        Runnable runnable = () -> {
            System.out.println("runMethod!");
            try {
                Thread.sleep(10000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread mainX = new Thread(mainGroup, runnable);
        mainX.setName("X");
        mainX.start();

        Thread newThread = new Thread(group, runnable);
        newThread.setName("Z");
        newThread.start();


        ThreadGroup[] listGroup = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
        Thread.currentThread().getThreadGroup().enumerate(listGroup);
        System.out.println("Main thread contains thread group:" + listGroup.length + " name: " + listGroup[0].getName());
        Thread[] listThread = new Thread[listGroup[0].activeCount()];
        listGroup[0].enumerate(listThread);
        System.out.println(listThread[0].getName());

        Thread[] allThreads = new Thread[mainGroup.activeCount()];
        mainGroup.enumerate(allThreads);
        for (Thread t : allThreads) {
            System.out.println("all threads:" + t.getName());
        }
    }
}
