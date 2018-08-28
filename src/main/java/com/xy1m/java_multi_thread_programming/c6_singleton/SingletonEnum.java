package com.xy1m.java_multi_thread_programming.c6_singleton;

/**
 * Created by gzhenpeng on 8/18/18
 */
public enum SingletonEnum {
    connectionFactory;
    private Object connection;

    private SingletonEnum() {
        connection = new Object();
    }

    public Object getConnection() {
        return connection;
    }
}
