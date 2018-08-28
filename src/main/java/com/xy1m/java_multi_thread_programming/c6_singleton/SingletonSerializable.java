package com.xy1m.java_multi_thread_programming.c6_singleton;

import java.io.Serializable;

/**
 * Created by gzhenpeng on 8/18/18
 */
public class SingletonSerializable implements Serializable {
    private static final long serialVersionUID = 888L;

    private static SingletonSerializable instance;

    private static class SingletonHandler {
        private static SingletonSerializable instance = new SingletonSerializable();
    }

    private SingletonSerializable() {
    }

    public static SingletonSerializable getInstance() {
        return SingletonSerializable.SingletonHandler.instance;
    }

    protected Object readResolve() {
        System.out.println("readResove is invoked!");
        return SingletonHandler.instance;
    }
}
