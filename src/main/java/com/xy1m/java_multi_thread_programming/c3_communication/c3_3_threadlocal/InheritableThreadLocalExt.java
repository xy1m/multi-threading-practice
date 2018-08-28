package com.xy1m.java_multi_thread_programming.c3_communication.c3_3_threadlocal;

import java.util.Date;

/**
 * Created by gzhenpeng on 6/28/18
 */
public class InheritableThreadLocalExt extends InheritableThreadLocal {
    @Override
    protected Object initialValue() {
        return new Date().getTime();
    }

    @Override
    protected Object childValue(Object parentValue) {
        return parentValue + " child";
    }
}
