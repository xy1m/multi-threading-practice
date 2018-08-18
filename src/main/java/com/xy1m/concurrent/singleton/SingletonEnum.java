package com.xy1m.concurrent.singleton;

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
