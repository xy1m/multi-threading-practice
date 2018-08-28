package com.xy1m.java_multi_thread_programming.c6_singleton;

/**
 * Created by gzhenpeng on 8/18/18
 */
public class SingletonStaticBlock {
    private static SingletonStaticBlock instance;

    private SingletonStaticBlock() {
    }

    static {
        instance = new SingletonStaticBlock();
        System.out.println("SingleStaticBlock initialized at " + System.nanoTime());
    }

    public static SingletonStaticBlock getInstance() {
        return instance;
    }
}
