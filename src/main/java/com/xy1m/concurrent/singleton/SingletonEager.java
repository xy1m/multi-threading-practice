package com.xy1m.concurrent.singleton;

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
