package com.xy1m.concurrent.singleton;

/**
 * Created by gzhenpeng on 8/18/18
 */
public class SingletonStaticClass {
    private static SingletonStaticClass instance;

    private static class SingletonHandler {
        private static SingletonStaticClass instance = new SingletonStaticClass();
    }

    private SingletonStaticClass() {
    }

    public static SingletonStaticClass getInstance() {
        return SingletonHandler.instance;
    }
}
