package com.xy1m.concurrent.communication.threadlocal;

/**
 * Created by gzhenpeng on 6/28/18
 */
public class ThreadLocalExt extends ThreadLocal {
    @Override
    protected Object initialValue() {
        return "Default George";
    }
}
