package com.xy1m.java_multi_thread_programming.c6_singleton;

/**
 * Created by gzhenpeng on 8/18/18
 */
public class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy() {
    }

    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
