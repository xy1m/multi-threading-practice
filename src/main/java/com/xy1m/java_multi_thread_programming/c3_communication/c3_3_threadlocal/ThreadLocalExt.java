package com.xy1m.java_multi_thread_programming.c3_communication.c3_3_threadlocal;

/**
 * Created by gzhenpeng on 6/28/18
 */
public class ThreadLocalExt extends ThreadLocal {
    @Override
    protected Object initialValue() {
        return "Default George";
    }
}
