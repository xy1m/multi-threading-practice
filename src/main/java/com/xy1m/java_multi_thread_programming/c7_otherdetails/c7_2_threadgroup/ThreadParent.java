package com.xy1m.java_multi_thread_programming.c7_otherdetails.c7_2_threadgroup;

/**
 * Created by gzhenpeng on 8/21/18
 */
public class ThreadParent {
    public static void main(String... args) {
        System.out.println("Thread name:" + Thread.currentThread().getName() + " ParentGroup name: " + Thread
                .currentThread()
                .getThreadGroup().getParent().getName());

        System.out.println("Thread name:" + Thread.currentThread().getName() + " parent parent group " + Thread
                .currentThread()
                .getThreadGroup().getParent().getParent().getName());
    }
}
