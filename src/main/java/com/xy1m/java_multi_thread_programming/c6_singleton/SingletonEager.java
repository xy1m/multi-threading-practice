package com.xy1m.java_multi_thread_programming.c6_singleton;

/**
 * Created by gzhenpeng on 8/18/18
 */
public class SingletonEager {
    private static SingletonEager instance = new SingletonEager();

    private SingletonEager() {

    }

    public static SingletonEager getInstance() {
        return instance;
    }
}
