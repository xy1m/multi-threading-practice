package com.xy1m.java_multi_thread_programming.c7_otherdetails.c7_2_threadgroup;

/**
 * Created by gzhenpeng on 8/19/18
 */
public class ThreadAutoGroup {
    public static void main(String... args) {
        String template = "Thread:%s, ThreadGroup:%s, ActiveGroupCount:%s";
        System.out.println(String.format(template,
                Thread.currentThread().getName(),
                Thread.currentThread().getThreadGroup().getName(),
                Thread.currentThread().getThreadGroup().activeGroupCount()));
        ThreadGroup group = new ThreadGroup("newGroup");
        System.out.println(String.format(template,
                Thread.currentThread().getName(),
                Thread.currentThread().getThreadGroup().getName(),
                Thread.currentThread().getThreadGroup().activeGroupCount()));
        ThreadGroup[] threadGroup = new ThreadGroup[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threadGroup);

        for (int i = 0; i < threadGroup.length; i++) {
            System.out.println("First ThreadGroup name: " + threadGroup[i].getName());
        }
    }

}
