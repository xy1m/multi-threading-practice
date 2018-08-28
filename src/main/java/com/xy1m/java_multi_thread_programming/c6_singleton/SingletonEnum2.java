package com.xy1m.java_multi_thread_programming.c6_singleton;

/**
 * Created by gzhenpeng on 8/18/18
 */
public class SingletonEnum2 {
    private enum MyEnumSingleton {
        connectionFactory;
        private Object connection;

        private MyEnumSingleton() {
            connection = new Object();
        }

        public Object getConnection() {
            return connection;
        }
    }

    public static Object getConnection() {
        return MyEnumSingleton.connectionFactory.getConnection();
    }
}
